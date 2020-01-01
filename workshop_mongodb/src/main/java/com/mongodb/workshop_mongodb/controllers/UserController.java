package com.mongodb.workshop_mongodb.controllers;

import com.mongodb.workshop_mongodb.dto.UserDTO;
import com.mongodb.workshop_mongodb.models.Post;
import com.mongodb.workshop_mongodb.models.User;
import com.mongodb.workshop_mongodb.services.PostService;
import com.mongodb.workshop_mongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable(name = "id") String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO,
                                          @PathVariable(name = "id") String id){
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Set<Post>> findPotsByUserId(@PathVariable(name = "id") String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPots());
    }

}
