package com.example.videolibrarybackend.auth.model.repository;

import com.example.videolibrarybackend.auth.model.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findAllByOrderByIdAsc();

    List<Video> findAllByUploaderIdOrderByUploaderIdAsc(Long UploaderId);
}
