package com.kolorsmoothies.erp.common.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;

    private int status;

    private String message;

    private T data;

    private String path;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    
    public static <T> ApiResponse<T> success(T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(200)
                .message("Success")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(200)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> failure(String message) {

        return ApiResponse.<T>builder()
                .success(false)
                .status(400)
                .message(message)
                .build();
    }
}