package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {
    private final BookService bookservice;

    public DummyBookFilter(BookService bookservice) {
        this.bookservice = bookservice;
    }

    @PostConstruct
    public void initialize() {
        bookservice.guardar(new Book(null, "La Bella y La Bestia", "Primer libro infantil", "La bestia", 900000, 4));
        try {
            Thread.sleep(43);
        } catch (InterruptedException e) {
        }
        bookservice.guardar(new Book(null, "El Capitan America", "Libro de Comics",
                "Marvel", 97000, 32));
        try {
            Thread.sleep(24);
        } catch (InterruptedException e) {
        }
        bookservice.guardar(new Book(null, "Superman",
                "El hombre de Acero", "Clark Kent", 234987,
                1));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.guardar(
                new Book(null, "King Kong", "Un gorila en la Isla", "King", 39675, 457));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.guardar(new Book(null, "Caperucita roja",
                "Es un clásico de la Abuela", "El lobo", 895329, 8));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
