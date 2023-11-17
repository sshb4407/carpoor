package com.project.carPoor.service;

import com.project.carPoor.domain.Member;
import com.project.carPoor.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(Member member) {

        this.memberRepository.save(member);
    }


    @Transactional(readOnly = true) // 읽기 전용
    public Map<String, String> validateHandling(Errors errors) {

        Map<String, String> validatorResult = new HashMap<>();

        // 유효성 검사에 실패한 필드 목록을 받아 오기
        for (FieldError error : errors.getFieldErrors()) { // Errors 를 통해, 유효성 검사 실패 목록 제단

            String validKeyName = String.format("valid_%s", error.getField()); // make form field name

            validatorResult.put(validKeyName, error.getDefaultMessage()); // put : form field name, default value
        }

        return validatorResult;
    }

    public Member getMemberByEmail(String email) {

        Optional<Member> oMember = this.memberRepository.findByEmail(email);

        return oMember.orElse(null);
    }

    public Member getMemberByLoginId(String loginId) {

        Optional<Member> LoginId = this.memberRepository.findByLoginId(loginId);

        if(LoginId.isPresent()) {
            return LoginId.get();
        } else {
            throw new RuntimeException("회원정보 없음");
        }

    }



}
