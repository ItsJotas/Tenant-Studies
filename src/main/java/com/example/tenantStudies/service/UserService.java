package com.example.tenantStudies.service;

import com.example.tenantStudies.model.User;
import com.example.tenantStudies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
