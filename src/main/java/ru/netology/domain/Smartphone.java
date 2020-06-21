package ru.netology.domain;


import java.util.Objects;

public class Smartphone extends Product {
    private String manufactured;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufactured) {
        super(id, name, price);
        this.manufactured = manufactured;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return manufactured.equals(that.manufactured);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufactured);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufactured + '\'' +
                '}';
    }
}
