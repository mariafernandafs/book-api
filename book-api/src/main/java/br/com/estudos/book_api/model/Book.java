package br.com.estudos.book_api.model;

public record Book (
        Long id,
        String title,
        String author,
        Double purchasePrice,
        Long internalCode)
{}
