package com.project.carPoor.service;

import com.project.carPoor.domain.EmailMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    private final MemberService memberService;

    public String sendMail(EmailMessage emailMessage, String type) {

        String authKey = createKey(); // authkey 생성

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();  // 전송 할 이메일 객체

        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(emailMessage.getTo()); // 이메일 받을 주소
            mimeMessageHelper.setSubject(emailMessage.getSubject()); // 이메일 주소
            mimeMessageHelper.setText(setContext(authKey, emailMessage.getTo(),type), true); // 전송할 이메일 내용( html 제작 )
            javaMailSender.send(mimeMessage); // 이메일 전송

            return authKey; // 제작 된 authkey return

        } catch (MessagingException e) {

            throw new RuntimeException(e); // 전송 실패시 throw
        }
    }

    private String createKey() { // authkey 생성 method

        Random random = new Random();

        StringBuffer key = new StringBuffer();

        for (int i = 0; i < 8; i++) {

            int index = random.nextInt(4);

            switch (index) {
                case 0: key.append((char) ((int) random.nextInt(26) + 97)); break;
                case 1: key.append((char) ((int) random.nextInt(26) + 65)); break;
                default: key.append(random.nextInt(9));
            }
        }

        return key.toString();
    }

    public String setContext(String code, String email ,String type) { // 이메일 내용(html) 변수 전달 및 제작

        Context context = new Context();

        context.setVariable("code", code);
        context.setVariable("email", email);

        return templateEngine.process(type, context);
    }



}
