package br.com.estudos.book_api.dto;

public record BookRequest(
        String title,
        String author
) {
}