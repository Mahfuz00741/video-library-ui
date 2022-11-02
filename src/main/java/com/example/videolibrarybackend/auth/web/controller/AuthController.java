package com.example.videolibrarybackend.auth.web.controller;

import com.example.videolibrarybackend.annotations.RestApiController;
import com.example.videolibrarybackend.auth.model.domain.Video;
import com.example.videolibrarybackend.auth.service.VideoService;
import com.example.videolibrarybackend.auth.web.dto.request.AuthRequestDto;
import com.example.videolibrarybackend.auth.web.dto.request.ReactRequestDto;
import com.example.videolibrarybackend.auth.web.dto.request.VideoRequestDto;
import com.example.videolibrarybackend.auth.web.dto.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestApiController
@RequestMapping(path = "auth/")
public class AuthController {

    @Autowired
    VideoService videoService;

    @PostMapping("video/react-by-video-and-user-id/{videoId}/{userId}")
    public void reactVideoById(@PathVariable Long videoId, @PathVariable Long userId, @RequestBody ReactRequestDto dto) {
        videoService.reactVideoById(videoId, userId, dto);
    }

    @GetMapping(path = "/")
    public String home() {
        return "Welcome";
    }

    @GetMapping(path = "video/get-list-by-uploader-id/{uploaderId}")
    public List<Video> getListByUploaderId(@PathVariable Long uploaderId) {
        return videoService.getVideoListByUploaderId(uploaderId);
    }



}
