package com.example.videolibrarybackend.auth.web.controller;

import com.example.videolibrarybackend.annotations.RestApiController;
import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.service.UserService;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestApiController
@RequestMapping(path = "api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "create")
    public User saveUser(@RequestBody AuthRequestDto dto) {
        return userService.saveUser(dto);
    }


}
