package br.com.estudos.book_api.exception;

public class BookBadRequestException extends RuntimeException {

    public BookBadRequestException(String message){
        super(message);
    }
}
