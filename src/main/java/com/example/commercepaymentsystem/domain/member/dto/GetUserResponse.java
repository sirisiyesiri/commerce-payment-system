package com.example.commercepaymentsystem.domain.member.dto;

import com.example.commercepaymentsystem.domain.member.entity.User;
import lombok.Getter;

@Getter
public class GetUserResponse {

    private final Long userId;
    private final String email;
    private final String name;
    private final String phone;

    public GetUserResponse(Long userId, String email, String name, String phone) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public static GetUserResponse from(User user) {
        return new GetUserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPhoneNumber()
        );
    }
}
