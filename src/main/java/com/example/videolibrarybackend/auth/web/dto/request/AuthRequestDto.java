package com.example.videolibrarybackend.auth.web.dto.request;

import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class AuthRequestDto extends BaseEntityDto {

    private String email;

    private String password;

    private String fullName;

    private String userName;
}
