package com.project.carPoor.validator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public abstract class AbstractValidator<T> implements Validator { // validator custom

    protected abstract void doValidate(final T form, final Errors erros); // 유효성 검증 로직

    @Override
    public boolean supports(Class<?> clazz) {

        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        try {

            doValidate((T) target, errors);

        } catch (RuntimeException e) {

            log.error("중복 검증 에러", e);

            throw e;
        }
    }
}
