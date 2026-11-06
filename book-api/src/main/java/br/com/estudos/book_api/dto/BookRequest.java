package br.com.estudos.book_api.dto;

import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank String title,
        @NotBlank String author
) {
}