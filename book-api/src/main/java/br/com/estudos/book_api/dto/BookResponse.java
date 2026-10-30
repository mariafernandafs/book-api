package br.com.estudos.book_api.dto;

public record BookResponse (
        Long id,
        String title,
        String author
)
{}
