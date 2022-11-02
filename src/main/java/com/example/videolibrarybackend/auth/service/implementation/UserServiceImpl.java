package com.example.videolibrarybackend.auth.service.implementation;

import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.model.repository.UserRepository;
import com.example.videolibrarybackend.auth.service.UserService;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(AuthRequestDto dto) {
        User user = new User();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
        return user;
    }

}
