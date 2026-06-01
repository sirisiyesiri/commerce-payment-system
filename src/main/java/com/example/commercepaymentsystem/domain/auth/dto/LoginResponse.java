package com.example.commercepaymentsystem.domain.auth.dto;

import com.example.commercepaymentsystem.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class LoginResponse {

    private final Long userId;
    private final String email;
    private final String name;
    private final String role;

    public LoginResponse(Long userId, String email, String name, String role) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public static LoginResponse from(Member member) {
        return new LoginResponse(
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getRole().name()
        );
    }
}
