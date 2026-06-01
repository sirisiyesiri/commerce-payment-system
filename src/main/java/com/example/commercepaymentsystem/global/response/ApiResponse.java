package com.example.commercepaymentsystem.global.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private final T data;

    private ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T>ApiResponse<T> of(int status, String message, T data) {
        return new ApiResponse<T>(status, message, data);
    }

    public static <T>ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<T>(200, message, data);
    }

    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<>(201, message, data);
    }
}
