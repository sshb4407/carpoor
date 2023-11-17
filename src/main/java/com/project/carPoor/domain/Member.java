package com.project.carPoor.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private String authKey;

    private boolean joinStatus;

    @OneToMany(mappedBy = "author")
    @OrderBy("id DESC")
    private List<Question> question;

}
