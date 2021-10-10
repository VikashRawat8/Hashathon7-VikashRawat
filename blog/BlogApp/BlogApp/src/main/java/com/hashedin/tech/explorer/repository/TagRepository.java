package com.hashedin.tech.explorer.repository;

import com.hashedin.tech.explorer.entity.Tag;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

  Set<Tag> findAllByNameIn(Iterable<String> names);
}
