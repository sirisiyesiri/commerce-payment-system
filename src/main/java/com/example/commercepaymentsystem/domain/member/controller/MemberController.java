package com.example.commercepaymentsystem.domain.member.controller;

import com.example.commercepaymentsystem.domain.member.dto.GetMemberResponse;
import com.example.commercepaymentsystem.domain.member.service.MemberService;
import com.example.commercepaymentsystem.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<GetMemberResponse>> getMyInfo(@AuthenticationPrincipal Long memberId) {
        GetMemberResponse response = memberService.getMyInfo(memberId);
        return ResponseEntity.ok(ApiResponse.ok("회원 정보 조회 성공", response));
    }

}
