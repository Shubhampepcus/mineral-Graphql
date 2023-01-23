package com.graphql.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.graphql.learn.entities.Company;
import com.graphql.learn.entities.User;
import com.graphql.learn.repositories.CompanyRepository;
import com.graphql.learn.repositories.UserRepository;

@Component
@Service
public class UserService {
    
    @Autowired 
    private UserRepository userRepository;
    
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User getUserById(int userId) {
        return userRepository.findByUserId(userId);
    }

}
