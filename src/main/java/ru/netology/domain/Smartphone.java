package ru.netology.domain;



public class Smartphone extends Product {
    private String manufactured;


    public Smartphone(int id, String name, int price, String manufactured) {
        super(id, name, price);
        this.manufactured = manufactured;
    }


    @Override
    public boolean matches(String search) {
        return super.matches(search) || manufactured.equalsIgnoreCase(search);
    }
}
