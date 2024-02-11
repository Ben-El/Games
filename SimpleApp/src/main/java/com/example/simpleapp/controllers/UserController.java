package com.example.simpleapp.controllers;

import com.example.simpleapp.dataaccess.dao.UserJooqDao;
import com.example.simpleapp.dataaccess.dao.UserRepository;
import com.example.simpleapp.dataaccess.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserJooqDao userJooqDao;
    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        //return userRepository.findAll();
        return userJooqDao.getAllUsers();
    }
    @GetMapping("/allSurnames")
    public List<String> getAllSurnames() {
        return userJooqDao.getAllSurnames();
    }

    @GetMapping("/userById")
    public ResponseEntity<User> getUserByIdViaRequestParam(@RequestParam("id") Integer userId) {
        return userRepository.findById(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/userByName")
    public ResponseEntity<User> getUser(@RequestParam(value = "name") String userName) {
        return userRepository.findByName(userName).map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (userRepository.findByName(user.getName()).isEmpty()) {
            //userRepository.save(user);
            userJooqDao.insertUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
}