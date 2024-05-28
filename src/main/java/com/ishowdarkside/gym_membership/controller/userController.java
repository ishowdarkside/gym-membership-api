package com.ishowdarkside.gym_membership.controller;


import com.ishowdarkside.gym_membership.entity.User;
import com.ishowdarkside.gym_membership.exception.InvalidFieldError;
import com.ishowdarkside.gym_membership.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {


    private UserService userService;

    @Autowired
    public userController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            ArrayList<String> errors = new ArrayList<>();
            bindingResult.getAllErrors().stream().forEach(e -> errors.add(e.getDefaultMessage()));
            return new ResponseEntity<>(new InvalidFieldError(errors),HttpStatus.BAD_REQUEST);

        }


        User createdUser = this.userService.createUser(user);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);

    }

}
