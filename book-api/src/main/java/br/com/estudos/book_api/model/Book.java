package br.com.estudos.book_api.model;

import br.com.estudos.book_api.dto.BookRequest;

public record Book (
        Long id,
        String title,
        String author)
{
    public Book(String title, String author) {
        this(null, title, author);
    }
}
