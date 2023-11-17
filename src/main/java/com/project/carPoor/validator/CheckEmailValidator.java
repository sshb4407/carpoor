package com.project.carPoor.validator;

import com.project.carPoor.controller.SignupForm;
import com.project.carPoor.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckEmailValidator extends AbstractValidator<SignupForm> { // 이메일 중복 유효성 검사

    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(SignupForm form, Errors errors) {

        if(this.memberRepository.existsByEmail(form.getEmail())) {

            errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일 입니다." );
        }
    }
}
