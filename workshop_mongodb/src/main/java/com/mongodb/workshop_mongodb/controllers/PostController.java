package com.mongodb.workshop_mongodb.controllers;

import com.mongodb.workshop_mongodb.dto.UserDTO;
import com.mongodb.workshop_mongodb.models.Post;
import com.mongodb.workshop_mongodb.models.User;
import com.mongodb.workshop_mongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable(name = "id") String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
