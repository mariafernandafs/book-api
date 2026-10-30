package br.com.estudos.book_api.controller;

import br.com.estudos.book_api.dto.BookResponse;
import br.com.estudos.book_api.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
