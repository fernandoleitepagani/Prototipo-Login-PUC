package com.example.SecureLoginPUC.config;

import java.io.IOException;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.SecureLoginPUC.service.RecaptchaService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RecaptchaFilter extends OncePerRequestFilter {

    private final RecaptchaService recaptchaService;

    public RecaptchaFilter(RecaptchaService recaptchaService) {
        this.recaptchaService = recaptchaService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Only check when the user submits the login form
        if ("POST".equalsIgnoreCase(request.getMethod())
                && "/login".equals(request.getRequestURI())) {

            String token = request.getParameter("g-recaptcha-response");

            if (!recaptchaService.isValid(token)) {
                response.sendRedirect("/login?error=captcha");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
