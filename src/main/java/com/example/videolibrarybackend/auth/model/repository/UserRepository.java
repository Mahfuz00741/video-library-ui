package com.example.videolibrarybackend.auth.model.repository;

import com.example.videolibrarybackend.auth.model.domain.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    UserTable findByEmail(String email);
    UserTable findByUserName(String userName);
}
