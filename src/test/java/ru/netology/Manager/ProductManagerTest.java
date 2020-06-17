package ru.netology.Manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class ProductManagerTest {
    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductManager manager;

    Smartphone first = new Smartphone(1, "Nokia 7plus", 17990, "Finland");
    Smartphone second = new Smartphone(2, "Samsung S10", 40000, "Korea");
    Smartphone third = new Smartphone(3, "Google Pixel 3", 50000, "U.S.A");
    Book one = new Book(1,"Дунайский лоцман", 450, "Ж.Верн");
    Book two = new Book(2, "Двенадцать стульев", 200, "И.Ильф,Е.Петров");
    Book three = new Book(3, "Шерлок Холмс", 360, "А.К.Дойл");


    @Test
    void addSmartphone() {
        Product[] returned = new Product[]{first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }

    @Test
    void addBook() {
        Product[] returned = new Product[]{one};
        doReturn(returned).when(repository).findAll();
        manager.add(one);
        Product[] expected = new Product[]{one};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }

    @Test
    void addAllSmartphone() {
        Product[] returned = new Product[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addAllBook() {
        Product[] returned = new Product[]{one, two, three};
        doReturn(returned).when(repository).findAll();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        Product[] expected = new Product[]{one, two, three};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }



}