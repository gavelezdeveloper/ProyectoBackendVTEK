package com.example.library.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> listarTodos(@RequestParam(required = false) String author, String title) {
        if ((author == null) && title == null) {
            return this.bookService.listarTodos();
        }
        if (author != null) {
            return this.bookService.buscarPorAutor(author);
        } else {
            return this.bookService.buscarPorTitulo(title);
        }
    }

    @GetMapping("/books/{bookId}")
    public Book listarLibro(@PathVariable String bookId) {
        return this.bookService.listarLibro(bookId);
    }

    @PostMapping("/books")
    public Book guardar(@RequestBody Book book) {
        return this.bookService.guardar(book);
    }

    @PutMapping("/books/{bookId}")
    public Book actualizarLibro(@PathVariable String bookId, @RequestBody Book book) {
        if (bookId.equals(book.getBookId())) {
            return this.bookService.actualizarLibro(bookId, book);
        } else {
            return null;
        }
    }

    @DeleteMapping("/books/{bookId}")
    public Book suprimir(@PathVariable String bookId) {
        return this.bookService.suprimir(bookId);
    }

}
