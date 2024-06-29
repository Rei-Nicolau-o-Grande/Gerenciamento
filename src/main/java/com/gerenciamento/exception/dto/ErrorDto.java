package com.gerenciamento.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorDto(

        @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
        LocalDateTime timestamp,

        String path,

        String method,

        Integer status,

        String error,

        String message
) {
}
