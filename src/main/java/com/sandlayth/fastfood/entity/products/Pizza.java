package com.sandlayth.fastfood.entity.products;

import java.util.List;

import javax.persistence.*;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.entity.Product;

@Entity
public class Pizza extends Product {
    @OneToMany
    private List<Price> prices;
    @OneToMany
    private List<Composition> compositions;

    protected Pizza() {}

    public Pizza(String name, Boolean appearsInMenu, Boolean isABase) {
        super(name, appearsInMenu, isABase);
    }

    public Pizza(String name, Boolean appearsInMenu, Boolean isABase, List<Price> prices, List<Composition> compositions) {
        super(name, appearsInMenu, isABase);
        this.prices = prices;
        this.compositions = compositions;
    }

    public Pizza(Long id, String name, Boolean appearsInMenu, Boolean isABase, List<Price> prices, List<Composition> compositions) {
        super(name, appearsInMenu, isABase);
        this.prices = prices;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
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

    @Override
    public String toString() {
        return "Pizza{" +
                super.toString() +
                "id=" + id +
                ", composition=" + compositions +
                ", prices=" + prices +
                '}';
    }
}