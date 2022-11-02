package com.example.videolibrarybackend.auth.web.dto.response;

import com.example.videolibrarybackend.auth.web.dto.response.UserResponseDto;
import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class ReactResponseDto extends BaseEntityDto {

    private Boolean isLike;

    private Boolean isDisLike;

    private Long userId;

    private UserResponseDto user;

}
