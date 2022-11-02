package com.example.videolibrarybackend.auth.service.implementation;

import com.example.videolibrarybackend.auth.model.domain.UserTable;
import com.example.videolibrarybackend.auth.model.repository.UserRepository;
import com.example.videolibrarybackend.auth.web.dto.response.UserResponseDto;
import com.example.videolibrarybackend.auth.model.domain.React;
import com.example.videolibrarybackend.auth.model.domain.Video;
import com.example.videolibrarybackend.auth.model.repository.ReactRepository;
import com.example.videolibrarybackend.auth.model.repository.VideoRepository;
import com.example.videolibrarybackend.auth.service.VideoService;
import com.example.videolibrarybackend.auth.web.dto.request.ReactRequestDto;
import com.example.videolibrarybackend.auth.web.dto.request.VideoRequestDto;
import com.example.videolibrarybackend.auth.web.dto.response.ReactResponseDto;
import com.example.videolibrarybackend.auth.web.dto.response.VideoResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ReactRepository reactRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Video saveVideo(VideoRequestDto dto) {
        Video video = new Video();
        if (dto.getVideoUrl().contains(".be")) {
            dto.setVideoUrl(dto.getVideoUrl().replace(".be", "be.com/embed"));
        } else {
            dto.setVideoUrl(dto.getVideoUrl().replace("watch?v=", "embed/"));
        }
        BeanUtils.copyProperties(dto, video);
        videoRepository.save(video);
        return video;
    }

    @Override
    public Video updateVideo(VideoRequestDto dto) {
        Optional<Video> video = videoRepository.findById(dto.getId());
        Video copyVideo = video.get();
        BeanUtils.copyProperties(dto, copyVideo, "id");
        videoRepository.save(copyVideo);
        return copyVideo;
    }

    @Override
    public VideoResponseDto findOneVideo(Long videoId) {
        VideoResponseDto dto = new VideoResponseDto();
        Optional<Video> v = videoRepository.findById(videoId);
        Video video = v.get();

        List<ReactResponseDto> list = new ArrayList<>();
        for (React res : video.getReact()) {
            ReactResponseDto newDto = new ReactResponseDto();
            BeanUtils.copyProperties(res, newDto);
            list.add(newDto);
        }
        BeanUtils.copyProperties(video, dto);
        dto.setReact(list);

        long totalLikes = video.getReact().stream().filter(f -> Objects.nonNull(f.getIsLike()) && f.getIsLike()).count();
        long totalDislikes = video.getReact().stream().filter(f -> Objects.nonNull(f.getIsDisLike()) && f.getIsDisLike()).count();
        dto.setTotalLike(totalLikes);
        dto.setTotalDislike(totalDislikes);

        dto.setUploader(userRepository.findById(dto.getUploaderId()).get());

        for (ReactResponseDto responseDto : dto.getReact()) {
            UserResponseDto dto1 = new UserResponseDto();
            UserTable user = userRepository.findById(responseDto.getUserId()).get();
            BeanUtils.copyProperties(user, dto1);
            responseDto.setUser(dto1);
        }
        return dto;
    }

    @Override
    public List<Video> getVideoList() {
        return videoRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void reactVideoById(Long videoId, Long userId, ReactRequestDto dto) {
        Optional<Video> v = videoRepository.findById(videoId);
        Video video = v.get();
        Optional<React> find = video.getReact().stream().filter(f -> f.getUserId().equals(userId)).findAny();

        /** If user id found in react table just update react by user id or create with video id and user id */
        if (find.isPresent()) {
            React react = reactRepository.findByVideoIdAndUserId(videoId, userId);
            if (dto.getReactType().equals("like")) {
                if (react.getIsLike() == null) {
                    react.setIsLike(true);
                    react.setIsDisLike(false);
                } else {
                    react.setIsLike(!react.getIsLike());
                    react.setIsDisLike(null);
                }
            } else {
                if (react.getIsDisLike() == null) {
                    react.setIsDisLike(true);
                    react.setIsLike(false);
                } else {
                    react.setIsDisLike(!react.getIsDisLike());
                    react.setIsLike(null);
                }
            }
            reactRepository.save(react);
        } else {
            React react = new React();
            react.setUserId(userId);
            if (dto.getReactType().equals("like")) {
                react.setIsLike(true);
            } else {
                react.setIsDisLike(true);
            }
            video.getReact().add(react);
            videoRepository.save(video);
        }
    }

    @Override
    public void videoViewIncrease(Long videoId) {
        Optional<Video> v = videoRepository.findById(videoId);
        Video video = v.get();
        video.setTotalView(video.getTotalView() + 1);
        videoRepository.save(video);
    }

    @Override
    public List<Video> getVideoListByUploaderId(Long uploaderId) {
        return videoRepository.findAllByUploaderIdOrderByUploaderIdAsc(uploaderId);
    }


}
