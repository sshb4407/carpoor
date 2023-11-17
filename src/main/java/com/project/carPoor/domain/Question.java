package com.project.carPoor.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Question {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime regDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "Text")
    private String content;

    private String answerStatus = "답변 중";

    private Boolean isPublic;

    @ManyToOne
    private Member author;

    @OneToOne(mappedBy = "question", cascade = CascadeType.REMOVE)
    private Answer answer;

}
