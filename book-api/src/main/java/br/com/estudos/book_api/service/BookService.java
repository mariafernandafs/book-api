package br.com.estudos.book_api.service;

import br.com.estudos.book_api.exception.BookNotFoundException;
import br.com.estudos.book_api.model.Book;
import br.com.estudos.book_api.repository.BookRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    public BookRespository bookRespository;

    public BookService(BookRespository bookRespository){
        this.bookRespository = bookRespository;
    }

    public List<Book> findAll(){
        return bookRespository.findAll();
    }

    public Book save(Book book){
       return bookRespository.save(book);
    }

    public Book getById(Long id){
        Optional<Book> book = bookRespository.getByID(id);
        if(!book.isEmpty()){
            return book.get();
        }
        else{
            throw new BookNotFoundException("Livro não encontrado");
        }
    }
}
