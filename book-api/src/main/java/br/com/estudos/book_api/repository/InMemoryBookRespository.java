package br.com.estudos.book_api.repository;

import br.com.estudos.book_api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryBookRespository implements BookRespository{
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
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

    public Optional<Book> getByID(Long id){
        Book book = books.get(id);
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<Book> updateByID(Long id, Book book) {
        Optional<Book> foundedBook = getByID(id);
        
        if(foundedBook.isPresent()){
            Book existingBook = foundedBook.get();
            Book updatedBook  = new Book(existingBook.id(), book.title(), book.author());

            books.replace(existingBook.id(), updatedBook);
            return Optional.ofNullable(updatedBook);
        }
        return Optional.empty();
    }
    @Override
    public void delete(Long id){
        Optional<Book> foundedBook = getByID(id);

        if(foundedBook.isPresent()){
            books.remove(id);
        }
    }
}
