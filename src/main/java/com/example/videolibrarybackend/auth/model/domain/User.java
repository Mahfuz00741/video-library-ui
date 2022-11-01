package com.example.videolibrarybackend.auth.model.domain;

import com.example.videolibrarybackend.model.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "USER_TABLE")
public class User extends BaseEntity {

    private String email;

    private String password;

    private String fullName;

    private String role;

}
