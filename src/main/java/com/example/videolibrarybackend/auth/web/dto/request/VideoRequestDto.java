package com.example.videolibrarybackend.auth.web.dto.request;

import com.example.videolibrarybackend.auth.model.domain.React;
import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

import java.util.List;

@Data
public class VideoRequestDto extends BaseEntityDto {

    private String videoTitle;

    private String videoUrl;

    private Long totalView;

    private Long uploaderId;

    private List<React> react;

}
