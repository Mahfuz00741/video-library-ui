package com.example.videolibrarybackend.auth.web.dto.response;

import com.example.videolibrarybackend.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class UserResponseDto extends BaseEntityDto {

    private String email;

    private String password;

    private String fullName;

}
