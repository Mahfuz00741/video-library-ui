package com.example.videolibrarybackend.services;

import com.example.videolibrarybackend.model.domain.Video;
import com.example.videolibrarybackend.web.dto.request.ReactRequestDto;
import com.example.videolibrarybackend.web.dto.request.VideoRequestDto;
import com.example.videolibrarybackend.web.dto.response.VideoResponseDto;

import java.util.List;

public interface VideoService {

    Video saveVideo(VideoRequestDto dto);
    Video updateVideo(VideoRequestDto dto);
    VideoResponseDto findOneVideo(Long videoId);
    List<Video> getVideoList();

    void reactVideoById(Long videoId, Long userId, ReactRequestDto dto);

    void videoViewIncrease (Long videoId);

}
