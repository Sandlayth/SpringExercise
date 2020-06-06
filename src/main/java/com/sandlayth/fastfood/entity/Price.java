package com.sandlayth.fastfood.entity;

import javax.persistence.*;

@Entity
@Table
public class Price {
    @Id
    @GeneratedValue
    private Long id;
    private PriceType type;
    @OneToOne
    private Size size;
    private Double price;

    protected Price() {
    }

    public Price(PriceType type, Size size, Double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Price(Long id, PriceType type, Size size, Double price) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriceType getType() {
        return type;
    }

    public void setType(PriceType type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", type=" + type +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}