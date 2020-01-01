package com.mongodb.workshop_mongodb.services;

import com.mongodb.workshop_mongodb.dto.UserDTO;
import com.mongodb.workshop_mongodb.models.User;
import com.mongodb.workshop_mongodb.repositories.UserRepository;
import com.mongodb.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
            Optional<User> obj = userRepository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User updateUser){
        User user = findById(updateUser.getId());
        updateData(user, updateUser);
        return userRepository.save(user);
    }

    private void updateData(User user, User updateUser){
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
