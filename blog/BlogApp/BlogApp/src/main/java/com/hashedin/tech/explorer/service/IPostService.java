package com.hashedin.tech.explorer.service;

import com.hashedin.tech.explorer.model.PostDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPostService {

  PostDto getPost(Long postId);

  PostDto createPost(@RequestBody PostDto post);
}
