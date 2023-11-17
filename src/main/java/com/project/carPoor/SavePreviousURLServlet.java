package com.project.carPoor;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SavePreviousURLServlet extends HttpServlet {

    @GetMapping("/savePreviousURL")
    public void savePreviousURL(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("PREVIOUS_URL", referer);
        response.setStatus(200);

        System.out.println(request.getSession().getAttribute("PREVIOUS_URL"));
    }
}