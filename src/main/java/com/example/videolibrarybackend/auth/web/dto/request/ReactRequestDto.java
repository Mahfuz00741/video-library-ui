package com.example.videolibrarybackend.auth.web.dto.request;

import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

@Data
public class ReactRequestDto extends BaseEntityDto {

    private Boolean isLike;

    private Boolean isDisLike;

    private Long userId;

    private String reactType;

}
