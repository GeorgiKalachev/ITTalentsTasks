package main;

import practice.Color;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private LocalDate expDate;
    private Color color;

    public Product(String name, double price, LocalDate expDate, Color color) {
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public Color getColor() {
        return color;
    }
}
