package com.vrapalis.www.libraries.websites.domain.post;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Optional;

import static com.vrapalis.www.libraries.websites.domain.common.ApiUrl.POST_RESOURCE_BASE_API_URL;
import static com.vrapalis.www.libraries.websites.domain.common.ApiUrl.WEBSITES_BASE_API_URL;

@RequestMapping(WEBSITES_BASE_API_URL + POST_RESOURCE_BASE_API_URL)
public interface PostRestController {
    @GetMapping("{id}")
    ResponseEntity<List<PostDto>> find(@PathVariable Optional<Integer> id, Pageable pageable);
}
