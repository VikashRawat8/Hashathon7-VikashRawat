package com.hashedin.tech.explorer.service.impl;

import com.hashedin.tech.explorer.entity.Tag;
import com.hashedin.tech.explorer.entity.User;
import com.hashedin.tech.explorer.repository.TagRepository;
import com.hashedin.tech.explorer.service.ITagService;
import com.hashedin.tech.explorer.util.constant.DefaultConstants;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagService implements ITagService {

  TagRepository tagRepository;

  @Override
  public Set<Tag> addAllTags(Set<String> tagList, final User author) {

    if (ObjectUtils.isEmpty(tagList)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No tags found");
    }

    final Set<String> collectedTags = tagList.stream()
        .filter(StringUtils::hasText)
        .map(String::toLowerCase)
        .collect(Collectors.toSet());

    if (collectedTags.size() > DefaultConstants.MAX_ALLOWED_TAGS) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Maximum " + DefaultConstants.MAX_ALLOWED_TAGS + " tags allowed");
    }

    final Set<Tag> foundTags = tagRepository.findAllByNameIn(collectedTags);

    Set<String> newTagNames;

    if (foundTags.size() == collectedTags.size()) {
      return foundTags;

    } else if (foundTags.isEmpty()) {
      newTagNames = collectedTags;

    } else {

      final Set<String> foundTagNames = foundTags.stream()
          .map(Tag::getName)
          .collect(Collectors.toSet());

      newTagNames = collectedTags.stream()
          .filter(tagName -> !foundTagNames.contains(tagName))
          .collect(Collectors.toSet());
    }
    final Set<Tag> newTags = newTagNames.stream()
        .map(tagName -> {
          final Tag tag = new Tag();
          tag.setName(tagName);
          return tag;
        })
        .collect(Collectors.toSet());

    if (!ObjectUtils.isEmpty(author)) {
      newTags.forEach(tag -> tag.setAddedBy(author));
    }

    final List<Tag> savedTags = tagRepository.saveAll(newTags);
    foundTags.addAll(savedTags);

    return foundTags;
  }
}
