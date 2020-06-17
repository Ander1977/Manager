package ru.netology.Manager;


import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repository;
    private int id;
    private String name;
    private int price;
    private String author;
    private String manufacturer;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Book book) {
        repository.save(book);
    }

    public void add(Smartphone smartphone) {
        repository.save(smartphone);
    }

    public boolean matches(Product product, String text) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(name)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(name)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(manufacturer)) {
                return true;
            }
        }
        return false;
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(product, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public Product[] searchBy(String text) {
        Product[] products = repository.findAll();
        Product[] result = new Product[products.length];
        for (int i = 0; i < result.length; i++) {
            int index = products.length - i - 1;
            result[i] = products[index];
        }
        return result;
    }

}
