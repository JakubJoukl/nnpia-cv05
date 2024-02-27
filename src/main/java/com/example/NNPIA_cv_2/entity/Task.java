package com.example.NNPIA_cv_2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    public int id;

    @Column(length = 255)
    private String title;

    @Column(length = 4000)
    private String description;

    @Column
    private Date creationDate;

    @Column
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AppUser author;
}
