package com.example.videolibrarybackend.auth.service;

import com.example.videolibrarybackend.auth.model.domain.Video;
import com.example.videolibrarybackend.auth.web.dto.request.ReactRequestDto;
import com.example.videolibrarybackend.auth.web.dto.request.VideoRequestDto;
import com.example.videolibrarybackend.auth.web.dto.response.VideoResponseDto;

import java.util.List;

public interface VideoService {

    Video saveVideo(VideoRequestDto dto);
    Video updateVideo(VideoRequestDto dto);
    VideoResponseDto findOneVideo(Long videoId);
    List<Video> getVideoList();

    void reactVideoById(Long videoId, Long userId, ReactRequestDto dto);

    void videoViewIncrease (Long videoId);

    List<Video> getVideoListByUploaderId(Long uploaderId);

}
