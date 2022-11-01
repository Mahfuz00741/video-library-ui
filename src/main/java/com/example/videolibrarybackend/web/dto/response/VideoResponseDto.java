package com.example.videolibrarybackend.web.dto.response;

import com.example.videolibrarybackend.auth.model.domain.User;
import com.example.videolibrarybackend.web.dto.BaseEntityDto;
import lombok.Data;

import java.util.List;

@Data
public class VideoResponseDto extends BaseEntityDto {

    private String videoTitle;

    private String videoUrl;

    private Long totalView;

    private Long uploaderId;

    private User uploader;

    private long totalLike;

    private long totalDislike;

    private List<ReactResponseDto> react;
}
