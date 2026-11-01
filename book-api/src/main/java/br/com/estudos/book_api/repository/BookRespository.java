package br.com.estudos.book_api.repository;

import br.com.estudos.book_api.dto.BookRequest;
import br.com.estudos.book_api.model.Book;

import java.util.List;

public interface BookRespository {
    List<Book> findAll();

    Book save(Book book);
}
