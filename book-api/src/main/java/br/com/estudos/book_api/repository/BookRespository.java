package br.com.estudos.book_api.repository;

import br.com.estudos.book_api.dto.BookRequest;
import br.com.estudos.book_api.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRespository {
    List<Book> findAll();

    Book save(Book book);

    Optional<Book> getByID(Long id);

    Optional<Book> updateByID(Long id, Book book);

    void delete(Long id);
}
