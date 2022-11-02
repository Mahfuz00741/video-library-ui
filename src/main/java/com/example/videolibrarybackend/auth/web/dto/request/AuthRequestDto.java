package com.example.videolibrarybackend.auth.web.dto.request;

import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto extends BaseEntityDto {

    private String email;

    private String password;

    private String fullName;

    private String userName;
}
