package com.mongodb.workshop_mongodb.services;

import com.mongodb.workshop_mongodb.models.Post;
import com.mongodb.workshop_mongodb.repositories.PostRepository;
import com.mongodb.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id){
            Optional<Post> obj = postRepository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
