package com.hashedin.tech.explorer.service.impl;

import com.hashedin.tech.explorer.entity.Post;
import com.hashedin.tech.explorer.entity.Tag;
import com.hashedin.tech.explorer.entity.User;
import com.hashedin.tech.explorer.model.PostDto;
import com.hashedin.tech.explorer.model.UserDto;
import com.hashedin.tech.explorer.repository.PostRepository;
import com.hashedin.tech.explorer.repository.UserRepository;
import com.hashedin.tech.explorer.service.IPostService;
import com.hashedin.tech.explorer.service.ITagService;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService implements IPostService {

  ConversionUtil conversionUtil;

  UserRepository userRepository;

  PostRepository postRepository;

  ITagService tagService;

  @Override
  public PostDto getPost(Long postId) {
    if (ObjectUtils.isEmpty(postId)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post id is required");
    }

    final Optional<Post> post = postRepository.findById(postId);

    if (post.isPresent()) {
      final PostDto response = conversionUtil.convert(post, PostDto.class);
      if (!ObjectUtils.isEmpty(post.get().getTags())) {
        response.setTagNames(post.get().getTags().stream().map(Tag::getName).collect(Collectors.toSet()));
      }
      return response;
    }

    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post with provided id is not present");
  }

  @Override
  public PostDto createPost(PostDto post) {
    final UserDto author = post.getAuthor();
    if (ObjectUtils.isEmpty(author) ||
        ObjectUtils.isEmpty(author.getId())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id not found");
    }

    final Optional<User> foundAuthor = userRepository.findById(author.getId());

    if (!foundAuthor.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with provided id not found");
    }

    Post savedPost = conversionUtil.convert(post, Post.class);
    savedPost.setAuthor(foundAuthor.get());

    // Getting tags
    if (!ObjectUtils.isEmpty(post.getTagNames())) {
      final Set<Tag> tags = tagService.addAllTags(post.getTagNames(), foundAuthor.get());

      if (!ObjectUtils.isEmpty(tags)) {savedPost.setTags(tags);}
    }
    savedPost = postRepository.save(savedPost);

    final PostDto response = conversionUtil.convert(savedPost, PostDto.class);
    if (!ObjectUtils.isEmpty(savedPost.getTags())) {
      response.setTagNames(savedPost.getTags().stream().map(Tag::getName).collect(Collectors.toSet()));
    }
    return response;
  }
}
