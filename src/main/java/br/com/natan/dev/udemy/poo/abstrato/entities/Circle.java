package br.com.natan.dev.udemy.poo.abstrato.entities;

import br.com.natan.dev.udemy.poo.abstrato.entities.enums.Color;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;

public class Circle extends Shape {

    private Double radius;

    public Circle() {
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(this.radius, TWO.intValue());
    }
}
