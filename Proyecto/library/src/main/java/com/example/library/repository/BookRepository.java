package com.example.library.repository;

import java.util.List;

import com.example.library.model.Book;

public interface BookRepository {
    public List<Book> listarTodos();
    public Book listarLibro(String bookId);
    public List<Book> buscarPorAutor(String author);
    public Book guardar(Book book);
    public Book suprimir(String bookId);
    public List<Book> buscarPorTitulo(String title);
}
