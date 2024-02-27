package com.example.NNPIA_cv_2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    private int id;

    @Column(length = 255)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = AppUser.class)
    @JoinTable(name = "app_user_role")
    private List<AppUser> appUsers;
}
