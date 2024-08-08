package com.userUpdate.service;

import com.userUpdate.model.User;
import com.userUpdate.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }else {
            throw  new RuntimeException("User not found with id" + id);
        }
    }
}