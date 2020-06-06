package com.sandlayth.fastfood.entity.products;

import java.util.List;

import javax.persistence.*;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.entity.Product;

@Entity
public class Composition extends Product {
    @OneToMany
    private List<Price> prices;
    private Double quantity;
    private Double cost;

    public Composition() {
    }

    public Composition(String name, Boolean appearsInMenu, Boolean isABase) {
        super(name, appearsInMenu, isABase);
    }

    public Composition(Long id, String name, Boolean appearsInMenu, Boolean isABase, List<Price> prices, Double quantity, Double cost) {
        super(name, appearsInMenu, isABase);
        this.id = id;
        this.prices = prices;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Composition{" +
                super.toString() +
                "id=" + id +
                ", prices=" + prices +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}