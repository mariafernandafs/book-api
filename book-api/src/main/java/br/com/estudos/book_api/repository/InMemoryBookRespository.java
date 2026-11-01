package br.com.estudos.book_api.repository;

import br.com.estudos.book_api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryBookRespository implements BookRespository{
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Book save(Book book) {
        Long id = sequence.incrementAndGet();

        Book savedBook = new Book(
                id,
                book.title(),
                book.author()
        );

        books.put(id, savedBook);

        return savedBook;
    }
}
