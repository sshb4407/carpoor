package com.project.carPoor.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {

    @Size(min = 3, max = 25, message = "3자 이상 25자 이하로 입력 해주세요.")
    @NotEmpty(message = " ID는 필수 항목 입니다.")
    private String loginId;

    @NotEmpty(message = " 비밀번호는 필수 항목 입니다.")
    private String password1;

    @NotEmpty(message = " 비밀번호 확인은 필수 항목 입니다.")
    private String password2;

    @NotEmpty(message = " 이름은 필수 항목 입니다.")
    private String name;

    @NotEmpty(message = " 전화번호는 필수 항목 입니다.")
    private String phoneNumber;

    @NotEmpty(message = " 이메일은 필수 항목 입니다.")
    @Email
    private String email;


}
