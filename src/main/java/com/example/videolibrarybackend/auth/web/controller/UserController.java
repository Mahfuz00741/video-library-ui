package com.example.videolibrarybackend.auth.web.controller;

import com.example.videolibrarybackend.annotations.RestApiController;
import com.example.videolibrarybackend.auth.model.domain.UserTable;
import com.example.videolibrarybackend.auth.service.UserService;
import com.example.videolibrarybackend.auth.service.implementation.CustomUserDetailsService;
import com.example.videolibrarybackend.auth.utility.JwtUtility;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import com.example.videolibrarybackend.auth.web.dto.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestApiController
@RequestMapping(path = "api/user/")
public class UserController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping(path = "create")
    public UserTable saveUser(@RequestBody AuthRequestDto dto) {
        return userService.saveUser(dto);
    }


    @PostMapping(path = "token")
    public AuthResponse getToken(@RequestBody AuthRequestDto dto) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    String.valueOf(dto.getUserName()), String.valueOf(dto.getPassword())
            ));
        } catch (BadCredentialsException e) {
            throw  new Exception("error");
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(dto.getUserName());

        final String token = jwtUtility.generateToken(String.valueOf(userDetails));

        return new AuthResponse(token);
    }
}
