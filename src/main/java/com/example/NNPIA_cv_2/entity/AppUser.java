package com.example.NNPIA_cv_2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/*
* Hodnoty direktiva: spring.jpa.hibernate.ddl-auto
*   create
*   create-drop
*   none
*   update
*   validate
* */
@Entity
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    private int id;

    @Column(length = 255)
    //@NotNull
    //@NotBlank
    //@Max(255)
    private String username;

    @Column(length = 255)
    private String password;

    @Column
    private boolean active;

    @Column
    private Date creationDate;

    @Column
    private Date updateDate;

    @OneToMany(mappedBy = "author")
    private List<Task> tasks;

    @ManyToMany(mappedBy = "appUsers")
    private List<Role> userRoles;
}
