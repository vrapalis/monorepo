package com.vrapalis.www.libraries.websites.domain.post;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    void save(PostEntity... posts);

    List<PostEntity> findOne(Integer id);

    List<PostEntity> findAll(Pageable pageable);
}
