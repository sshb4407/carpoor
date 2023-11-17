package com.project.carPoor.validator;

import com.project.carPoor.controller.SignupForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CheckPasswordValidator extends AbstractValidator<SignupForm> { // 비밀번호 2중 확인 검사

    @Override
    protected void doValidate(SignupForm form, Errors errors) {

        if(!form.getPassword1().equals(form.getPassword2())) {

            errors.rejectValue("password2", "비밀번호 확인 실패", "비밀번호가 일치하지 않습니다.");
        }


    }
}
