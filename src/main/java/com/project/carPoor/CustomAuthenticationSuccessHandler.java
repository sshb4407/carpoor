package com.project.carPoor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getAuthorities() != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // 권한에 따른 URL 설정
            if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                setDefaultTargetUrl("/member/admin");
            } else {
                // 세션에서 PREVIOUS_URL 값을 가져옵니다.
                String previousUrl = (String) request.getSession().getAttribute("PREVIOUS_URL");

                if (previousUrl != null && !previousUrl.isBlank()) {
                    // 가져온 URL로 리다이렉트합니다.
                    getRedirectStrategy().sendRedirect(request, response, previousUrl);
                    // URL 사용 후 세션에서 삭제합니다.
                    request.getSession().removeAttribute("PREVIOUS_URL");
                    return; // 리다이렉트 후 추가 동작을 중단합니다.
                } else {
                    // PREVIOUS_URL 값이 없는 경우 기본 URL로 설정합니다.
                    setDefaultTargetUrl("/member/showMemberInfo");
                }
            }
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
