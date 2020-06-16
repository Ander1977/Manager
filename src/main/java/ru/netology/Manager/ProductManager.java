package ru.netology.Manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Productrepository;

public class ProductManager {
    private Productrepository repository;
    private int id;
    private String name;
    private int price;
    private String author;
    private String manufacturer;

    public ProductManager(Productrepository repository) {
        this.repository = repository;
    }

    public void add(Book book) {
        repository.save(book);
    }

    public void add(Smartphone smartphone) {
        repository.save(smartphone);
    }
}
