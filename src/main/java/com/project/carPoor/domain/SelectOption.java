package com.project.carPoor.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;


@Getter
@Setter
@Entity // question 테이블
public class SelectOption {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column() // VARCHAR(200)
    private Long userId;


    @ElementCollection
    @Column(name = "option_id")
    @Nullable
    private List<Integer> optionId;

    @Column()
    private Integer inColorId;


    @Column()
    private Integer outColorId;

    @Column()  //옵션 가격
    private Integer wholePrice;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createDate;


    @NonNull
    private String outImgUrl;

    @NonNull
    private String inImgUrl;




}
