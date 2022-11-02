package com.example.videolibrarybackend.auth.model.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "REACT_TABLE")
public class React extends BaseEntity{

    private Boolean isLike;

    private Boolean isDisLike;

    private Long userId;

}
