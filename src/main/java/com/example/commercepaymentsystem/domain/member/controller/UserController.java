package com.example.commercepaymentsystem.domain.member.controller;

import com.example.commercepaymentsystem.domain.member.dto.GetUserResponse;
import com.example.commercepaymentsystem.domain.member.service.UserService;
import com.example.commercepaymentsystem.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<GetUserResponse>> getMyInfo(@AuthenticationPrincipal Long memberId) {
        GetUserResponse response = userService.getMyInfo(memberId);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

}
