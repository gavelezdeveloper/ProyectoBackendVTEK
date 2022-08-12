package com.example.library.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listarTodos() {
        return bookRepository.listarTodos();
    }

    public Book listarLibro(String id) {
        return bookRepository.listarLibro(id);
    }

    public List<Book> buscarPorAutor(String author) {
        return bookRepository.buscarPorAutor(author);
    }

    public Book guardar(Book book) {
        book.setBookId(null);
        return bookRepository.guardar(book);
    }

    public Book actualizarLibro(String bookId, Book book) {
        Book bookVar = bookRepository.listarLibro(bookId);
        if (bookVar == null)  {
            return null;
        }
        book.setBookId(bookId);
        return bookRepository.guardar(book);
    }

    public Book suprimir(String id) {
        return bookRepository.suprimir(id);
    }

    public List<Book> buscarPorTitulo(String title) {
        return bookRepository.buscarPorTitulo(title);
    }
}
