package br.com.estudos.book_api.service;

import br.com.estudos.book_api.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public List<BookResponse> findAll(){
        return List.of(new BookResponse(1L, "Clean Code", "Robert C. Martin"),
                new BookResponse(2L,"Effective Java", "Joshua Bloch"));
    }

}
