package com.example.videolibrarybackend.web.controller;

import com.example.videolibrarybackend.annotations.RestApiController;
import com.example.videolibrarybackend.model.domain.Video;
import com.example.videolibrarybackend.services.VideoService;
import com.example.videolibrarybackend.web.dto.request.ReactRequestDto;
import com.example.videolibrarybackend.web.dto.request.VideoRequestDto;
import com.example.videolibrarybackend.web.dto.response.VideoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestApiController
@RequestMapping(path = "api/video/")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("save")
    private Video saveVideo(@RequestBody VideoRequestDto videoRequestDto) {
        return videoService.saveVideo(videoRequestDto);
    }

    @PutMapping("update")
    private Video updateVideo(@RequestBody VideoRequestDto dto) {
        return videoService.updateVideo(dto);
    }

    @GetMapping("find-one/{videoId}")
    public VideoResponseDto findOne(@PathVariable Long videoId) {
        return videoService.findOneVideo(videoId);
    }

    @GetMapping("get-list")
    public List<Video> findAll() {
        return videoService.getVideoList();
    }


    @PostMapping("react-by-video-and-user-id/{videoId}/{userId}")
    public void reactVideoById(@PathVariable Long videoId, @PathVariable Long userId, @RequestBody ReactRequestDto dto) {
        videoService.reactVideoById(videoId, userId, dto);
    }

    @GetMapping(path = "view-increase-by-video-id/{videoId}")
    public void videoViewIncrease(@PathVariable Long videoId) {
        videoService.videoViewIncrease(videoId);
    }

}
