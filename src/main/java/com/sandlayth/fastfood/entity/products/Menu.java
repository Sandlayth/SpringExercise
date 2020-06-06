package com.sandlayth.fastfood.entity.products;

import java.util.List;

import javax.persistence.*;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.entity.Product;

@Entity
public class Menu extends Product {
    @OneToOne
    private Price prices;
    @OneToMany
    private List<Product> products;

    protected Menu() {}

    public Menu(String name, Boolean appearsInMenu, Boolean isABase) {
        super(name, appearsInMenu, isABase);
    }

    public Menu(String name, Boolean appearsInMenu, Boolean isABase, Price prices, List<Product> products) {
        super(name, appearsInMenu, isABase);
        this.prices = prices;
        this.products = products;
    }

    public Menu(Long id, String name, Boolean appearsInMenu, Boolean isABase, Price prices, List<Product> products) {
        super(name, appearsInMenu, isABase);
        this.id = id;
        this.prices = prices;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Price getPrices() {
        return prices;
    }

    public void setPrices(Price prices) {
        this.prices = prices;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Menu{" +
                super.toString() +
                "id=" + id +
                ", prices=" + prices +
                ", products=" + products +
                '}';
    }
}