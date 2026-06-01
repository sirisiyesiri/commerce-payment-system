package com.example.commercepaymentsystem.domain.auth.dto;

import com.example.commercepaymentsystem.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class SignupResponse {

    private final Long userId;
    private final String email;
    private final String name;

    public SignupResponse(Long userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public static SignupResponse from(Member member) {
        return new SignupResponse(
                member.getId(),
                member.getEmail(),
                member.getName()
        );
    }
}
