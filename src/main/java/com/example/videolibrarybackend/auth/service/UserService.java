package com.example.videolibrarybackend.auth.service;

import com.example.videolibrarybackend.auth.model.domain.UserTable;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserTable saveUser(AuthRequestDto dto);

}
