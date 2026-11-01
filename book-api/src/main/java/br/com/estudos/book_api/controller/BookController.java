package br.com.estudos.book_api.controller;

import br.com.estudos.book_api.dto.BookRequest;
import br.com.estudos.book_api.dto.BookResponse;
import br.com.estudos.book_api.model.Book;
import br.com.estudos.book_api.service.BookService;
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
    public BookResponse save(@RequestBody BookRequest bookRequest){
        Book book = new Book(bookRequest.title(), bookRequest.author());
        Book savedBook = bookService.save(book);
        return new BookResponse(savedBook.id(), savedBook.title(), savedBook.author());
    }
}
