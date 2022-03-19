package com.application.services;

import com.application.persistence.entities.User;
import com.application.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user){ return userRepository.save(user); }

    public User findUserByRole(long idRole) { return userRepository.findUserByRoleType(idRole); }

    public User findUserByID(long id){ return userRepository.findUserByID(id); }

}
