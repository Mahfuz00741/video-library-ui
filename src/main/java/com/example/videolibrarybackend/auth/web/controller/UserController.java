package com.example.videolibrarybackend.auth.web.controller;

import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.service.UserService;
import com.example.videolibrarybackend.auth.web.dto.request.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    public User saveUser(@RequestBody UserRequestDto dto) {
        return userService.saveUser(dto);
    }

    @PostMapping(path = "login-user")
    public String loginUser(@RequestBody UserRequestDto dto) {
        return userService.loginUser(dto);
    }

    @GetMapping(path = "logout-user/{userId}")
    public void logoutUser(@PathVariable Long userId) {
        userService.logoutUser(userId);
    }

}
