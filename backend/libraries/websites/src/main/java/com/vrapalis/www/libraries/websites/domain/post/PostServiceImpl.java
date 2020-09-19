package com.vrapalis.www.libraries.websites.domain.post;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public void save(PostEntity... posts) {
        System.out.println(Arrays.toString(posts));
    }

    @Override
    public List<PostEntity> findOne(Integer id) {
        return null;
    }

    @Override
    public List<PostEntity> findAll(Pageable pageable) {
        return null;
    }
}

