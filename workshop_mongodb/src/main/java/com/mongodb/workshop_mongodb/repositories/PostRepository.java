package com.mongodb.workshop_mongodb.repositories;

import com.mongodb.workshop_mongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
