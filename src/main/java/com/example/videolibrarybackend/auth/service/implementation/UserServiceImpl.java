package com.example.videolibrarybackend.auth.service.implementation;

import com.example.videolibrarybackend.auth.config.JwtUtil;
import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.auth.model.repository.UserRepository;
import com.example.videolibrarybackend.auth.service.UserService;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import com.example.videolibrarybackend.auth.web.dto.response.AuthResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User saveUser(AuthRequestDto dto) {
        User user = new User();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public ResponseEntity<?> loginUser(AuthRequestDto dto) throws Exception {
        try {
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword());
            authenticationManager.authenticate(user);
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        final String jwt = jwtUtil.generateToken(dto.getUserName());
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
