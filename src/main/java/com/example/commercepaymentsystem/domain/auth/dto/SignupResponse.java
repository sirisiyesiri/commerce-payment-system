package com.example.commercepaymentsystem.domain.auth.dto;

import com.example.commercepaymentsystem.domain.member.entity.User;
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

    public static SignupResponse from(User user) {
        return new SignupResponse(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }
}
