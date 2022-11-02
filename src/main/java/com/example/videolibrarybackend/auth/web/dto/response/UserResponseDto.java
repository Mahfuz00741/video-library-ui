package com.example.videolibrarybackend.auth.web.dto.response;

import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class UserResponseDto extends BaseEntityDto {

    private String email;

    private String password;

    private String fullName;

}
