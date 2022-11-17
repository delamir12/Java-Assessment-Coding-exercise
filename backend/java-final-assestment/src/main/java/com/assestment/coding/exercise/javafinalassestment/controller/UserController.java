package com.assestment.coding.exercise.javafinalassestment.controller;


import com.assestment.coding.exercise.javafinalassestment.entity.User;
import com.assestment.coding.exercise.javafinalassestment.service.impl.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000/")
@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUsers(){
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {

        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addusers")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }



}
