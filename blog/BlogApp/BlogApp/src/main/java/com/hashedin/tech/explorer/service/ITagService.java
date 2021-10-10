package com.hashedin.tech.explorer.service;

import com.hashedin.tech.explorer.entity.Tag;
import com.hashedin.tech.explorer.entity.User;
import java.util.Set;

public interface ITagService {

  Set<Tag> addAllTags(Set<String> tagList, User author);
}
