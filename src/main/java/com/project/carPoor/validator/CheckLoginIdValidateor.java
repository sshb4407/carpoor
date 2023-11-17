package com.project.carPoor.validator;

import com.project.carPoor.controller.SignupForm;
import com.project.carPoor.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckLoginIdValidateor extends AbstractValidator<SignupForm> { // 로그인 아이디 중복 유효성 검사

    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(SignupForm form, Errors errors) {

        if(this.memberRepository.existsByLoginId(form.getLoginId())) {

            errors.rejectValue("loginId", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }

    }

}
