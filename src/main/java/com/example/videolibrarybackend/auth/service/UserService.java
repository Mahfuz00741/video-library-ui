package com.example.videolibrarybackend.auth.service;

import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User saveUser(AuthRequestDto dto);
    ResponseEntity<?> loginUser(AuthRequestDto dto) throws Exception;

}
