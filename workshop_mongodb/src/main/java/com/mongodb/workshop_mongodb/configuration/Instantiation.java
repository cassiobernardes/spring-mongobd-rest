package com.mongodb.workshop_mongodb.configuration;

import com.mongodb.workshop_mongodb.dto.AuthorDTO;
import com.mongodb.workshop_mongodb.dto.CommentDTO;
import com.mongodb.workshop_mongodb.models.Post;
import com.mongodb.workshop_mongodb.models.User;
import com.mongodb.workshop_mongodb.repositories.PostRepository;
import com.mongodb.workshop_mongodb.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, new Date(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, new Date(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", new Date(), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", new Date(), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", new Date(), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPots().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
