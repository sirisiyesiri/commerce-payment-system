package com.example.commercepaymentsystem.global.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final int httpstatus;
    private final String message;
    private final T data;

    private ApiResponse(int httpstatus, String message, T data) {
        this.httpstatus = httpstatus;
        this.message = message;
        this.data = data;
    }

    public static <T>ApiResponse<T> of(int httpstatus, String message, T data) {
        return new ApiResponse<T>(httpstatus, message, data);
    }

    public static <T>ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<T>(200, message, data);
    }

    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<>(201, message, data);
    }
}
