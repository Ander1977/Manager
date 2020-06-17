package ru.netology.repository;


import ru.netology.domain.Product;


public class ProductRepository {
    Product[] products = new Product[0];


    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        tmp = products;
    }

    public void removeById(int id) {
        int lengthProduct = products.length - 1;
        Product[] tmpProduct = new Product[lengthProduct];
        for (Product product : products) {
            if (product.getId() != id) {
                int index = 0;
                tmpProduct[index] = product;
                index++;
            }
        }
        tmpProduct = products;
    }
}
