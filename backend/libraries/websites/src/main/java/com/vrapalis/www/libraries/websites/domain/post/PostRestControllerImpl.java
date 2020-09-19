package com.vrapalis.www.libraries.websites.domain.post;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PostRestControllerImpl implements PostRestController {
    private PostService postService;

    @Override
    public ResponseEntity<List<PostDto>> find(Optional<Integer> id, Pageable pageable) {
        return ResponseEntity.of(null);
    }
}
