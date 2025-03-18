package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class Userimplementation {
    
    @Autowired
    UserRepo userRepo;
    
    public List<User> getAll() {
        return userRepo.findAll();
    }
    
    public User getById(int id) {
        return userRepo.findById(id).orElse(null);
    }
    
    public void add(User user) {
        userRepo.save(user);
    }
    
    public User update(User user) {
        Optional<User> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            return userRepo.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }
    
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}