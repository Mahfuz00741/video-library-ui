package com.example.videolibrarybackend.auth.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class UserTable extends BaseEntity {

    @Column(unique = true)
    private String email;

    private String password;

    private String fullName;

    private String userName;
}
