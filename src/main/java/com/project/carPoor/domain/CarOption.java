package com.project.carPoor.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // question 테이블
public class CarOption {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 200) // VARCHAR(200)
    private String name;

    @Column(columnDefinition = "TEXT") // TEXT
    private String imgUrl;

    @Column()  //옵션 가격
    private long price;

    @Column(length = 500)   // 옵션 설명
    private String information;

    @CreationTimestamp
    private LocalDateTime createDate;



}
