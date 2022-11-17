package com.assestment.coding.exercise.javafinalassestment.service.impl;


import com.assestment.coding.exercise.javafinalassestment.entity.User;
import com.assestment.coding.exercise.javafinalassestment.repository.UserRepository;
import com.assestment.coding.exercise.javafinalassestment.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
            return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id,User user) {
        User currentUser = userRepository.findById(id);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        currentUser.setEmail(user.getEmail());
        return currentUser = userRepository.save(user);

    }
}
