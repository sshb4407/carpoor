package com.project.carPoor.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailMessage { // 발송할 이메일을 만들기 위해 존재

    private String to;
    private String subject;
    private String message;
}
