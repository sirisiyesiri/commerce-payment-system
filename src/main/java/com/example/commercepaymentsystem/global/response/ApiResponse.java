package com.example.commercepaymentsystem.global.response;

import com.example.commercepaymentsystem.global.error.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final int httpStatus;
    private final String message;
    private final T data;

    private ApiResponse(int httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(200, null, data);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(201, null, data);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(204, null, data);
    }

    public static ApiResponse<Void> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static ApiResponse<Void> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), message, null);
    }

    public static ApiResponse<Void> error(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}
