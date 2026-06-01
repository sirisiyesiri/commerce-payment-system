package com.example.commercepaymentsystem.domain.auth.controller;

import com.example.commercepaymentsystem.domain.auth.dto.LoginRequest;
import com.example.commercepaymentsystem.domain.auth.dto.SignupRequest;
import com.example.commercepaymentsystem.domain.auth.dto.SignupResponse;
import com.example.commercepaymentsystem.domain.auth.service.AuthService;
import com.example.commercepaymentsystem.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponse>> signup(@Valid @RequestBody SignupRequest request) {
        SignupResponse response = authService.signup(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("회원가입 성공", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Void>> login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        headers.set("Access-Control-Expose-Headers", HttpHeaders.AUTHORIZATION);

        return ResponseEntity.ok()
                .headers(headers)
                .body(ApiResponse.ok("로그인 성공", null));
    }
}
