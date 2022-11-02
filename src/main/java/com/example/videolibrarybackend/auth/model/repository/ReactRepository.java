package com.example.videolibrarybackend.auth.model.repository;

import com.example.videolibrarybackend.auth.model.domain.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<React, Long> {

    React findByUserId(Long userId);

    @Query(value = "select * from react_table rt join video_table_react vtr on rt.id = vtr.react_id where vtr.video_id =? and rt.user_id=?", nativeQuery = true)
    React findByVideoIdAndUserId(Long videoId, Long userId);
}
