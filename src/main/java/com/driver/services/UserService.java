package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User user = new User();
        user.setFirstname("test");
        user.setLastname(("test"));
        user.setUsername(username);
        user.setPassword(password);

        User savedUser = userRepository3.save(user);

        return savedUser;
    }

    public void deleteUser(int userId){
        Optional<User> userOptional = userRepository3.findById(userId);
        if(userOptional.isPresent())
            userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        Optional<User> optionalUser = userRepository3.findById(id);
        User user = optionalUser.get();
        if(Objects.isNull(user))
            user.setPassword(password);

        return user;
    }
}
