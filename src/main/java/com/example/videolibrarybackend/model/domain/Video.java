package com.example.videolibrarybackend.model.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "VIDEO_TABLE")
public class Video extends BaseEntity{

    private String videoTitle;

    private String videoUrl;

    private Long totalView;

    private Long uploaderId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<React> react;

}
