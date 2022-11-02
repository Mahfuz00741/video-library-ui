package com.example.videolibrarybackend.auth.web.dto.response;

import com.example.videolibrarybackend.auth.model.domain.UserTable;
import com.example.videolibrarybackend.auth.web.dto.BaseEntityDto;
import lombok.Data;

import java.util.List;

@Data
public class VideoResponseDto extends BaseEntityDto {

    private String videoTitle;

    private String videoUrl;

    private Long totalView;

    private Long uploaderId;

    private UserTable uploader;

    private long totalLike;

    private long totalDislike;

    private List<ReactResponseDto> react;
}
