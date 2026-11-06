package br.com.estudos.book_api.service;

import br.com.estudos.book_api.dto.BookRequest;
import br.com.estudos.book_api.exception.BookBadRequestException;
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
        if(book == null){
            throw new BookBadRequestException("Para cadastrar um livro é necessário o envio dos dados");
        }
       return bookRespository.save(book);
    }

    public Book getById(Long id){
        Optional<Book> book = bookRespository.getByID(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            throw new BookNotFoundException("Livro não encontrado");
        }
    }
    public Book updateByID(Long id, BookRequest bookRequest){
        Optional<Book> book = bookRespository.updateByID(id,new Book(bookRequest.title(), bookRequest.author()));
        if(book.isPresent()){
            return book.get();
        }
        throw new BookNotFoundException("Livro não encontrado!");
    }

    public void delete(Long id){
        bookRespository.delete(id);
    }
}
