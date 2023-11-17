package com.project.carPoor.service;

import com.project.carPoor.controller.UserRole;
import com.project.carPoor.domain.Member;
import com.project.carPoor.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> _member = this.memberRepository.findByLoginId(username);

        if(_member.isEmpty()) { // 계정 존재하는지 확인
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Member member = _member.get();

        if(!member.isJoinStatus()) { // 회원의 이메일 인중 여부 확인
            throw new IllegalStateException("회원가입이 완료되지 않은 회원입니다.");
        }


        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(username)) { // 아이디 admin 일 경우 admin 권한 부여
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else { // admin 아닐 경우 일반 user 권한 부여
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(member.getLoginId(), member.getPassword(), authorities);
        // Spring Security 가 return 받아서 비밀번호가 일치하는지 조회하는 내부로직 수행


    }
}
