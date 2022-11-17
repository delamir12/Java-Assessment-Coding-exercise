package com.assestment.coding.exercise.javafinalassestment.service;

import com.assestment.coding.exercise.javafinalassestment.entity.User;
import java.util.List;

public interface UserService  {

    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);
}
