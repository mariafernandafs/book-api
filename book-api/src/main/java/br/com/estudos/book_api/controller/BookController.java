package br.com.estudos.book_api.controller;

import br.com.estudos.book_api.dto.BookRequest;
import br.com.estudos.book_api.dto.BookResponse;
import br.com.estudos.book_api.model.Book;
import br.com.estudos.book_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAll(){
        List<Book> books = bookService.findAll();
        System.out.println("Quantidade de livros: " + books.size());

        return bookService.findAll()
                .stream()
                .map(book -> new BookResponse(
                        book.id(),
                        book.title(),
                        book.author()
                ))
                .toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookResponse save(@Valid @RequestBody BookRequest bookRequest){
        Book book = new Book(bookRequest.title(), bookRequest.author());
        Book savedBook = bookService.save(book);
        return new BookResponse(savedBook.id(), savedBook.title(), savedBook.author());
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id){
        Book book = bookService.getById(id);
        return new BookResponse(book.id(), book.title(), book.author());
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest){
        Book updatedBook = bookService.updateByID(id, bookRequest);
        return new BookResponse(updatedBook.id(), updatedBook.title(), updatedBook.author());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }
}
