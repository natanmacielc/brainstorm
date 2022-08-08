package br.com.natan.dev.udemy.poo.abstrato.entities;

import br.com.natan.dev.udemy.poo.abstrato.entities.enums.Color;

public class Rectangle extends Shape {

    private Double height;

    private Double width;

    public Rectangle() {
    }

    public Rectangle(Color color, Double height, Double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public Double area() {
        return this.height * this.width;
    }
}
