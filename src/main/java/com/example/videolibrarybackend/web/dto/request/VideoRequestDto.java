package com.example.videolibrarybackend.web.dto.request;

import com.example.videolibrarybackend.model.domain.React;
import com.example.videolibrarybackend.web.dto.BaseEntityDto;
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
