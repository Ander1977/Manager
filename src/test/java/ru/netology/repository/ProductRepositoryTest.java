package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Smartphone first = new Smartphone(1, "Nokia 7plus", 17990, "Finland");
    Smartphone second = new Smartphone(2, "Samsung S10", 40000, "Korea");
    Smartphone third = new Smartphone(3, "Google Pixel 3", 50000, "U.S.A");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

    }

    @Test
    void shouldSave() {
        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


}