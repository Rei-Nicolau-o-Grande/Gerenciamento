package com.gerenciamento.dto;

import java.util.List;

public record PaginationDto<T>(
        List<T> content,
        Integer page,
        Integer size,
        Integer totalPages,
        Long totalElements
) {
}
