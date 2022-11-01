package com.example.videolibrarybackend.auth.service;

import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.web.dto.request.UserRequestDto;

public interface UserService {

    User saveUser(UserRequestDto dto);
    String loginUser(UserRequestDto dto);
    void logoutUser(Long userId);

}
