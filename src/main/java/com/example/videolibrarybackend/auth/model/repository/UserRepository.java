package com.example.videolibrarybackend.auth.model.repository;

import com.example.videolibrarybackend.auth.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
