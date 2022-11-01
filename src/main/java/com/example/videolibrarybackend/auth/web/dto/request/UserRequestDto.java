package com.example.videolibrarybackend.auth.web.dto.request;

import com.example.videolibrarybackend.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class UserRequestDto extends BaseEntityDto {

    private String email;

    private String password;

    private String fullName;

}
