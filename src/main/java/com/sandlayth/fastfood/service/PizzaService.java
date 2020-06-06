package com.sandlayth.fastfood.service;

import java.util.List;

import com.sandlayth.fastfood.entity.products.Pizza;
import com.sandlayth.fastfood.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza savePizza(Pizza pizza) { return pizzaRepository.save(pizza); }
    public List<Pizza> savePizzas(List<Pizza> pizzas) { return pizzaRepository.saveAll(pizzas); }

    public List<Pizza> getPizzas() { return pizzaRepository.findAll(); }
    public Pizza getPizzaById(long id) { return pizzaRepository.findById(id).orElse(null); }
    public List<Pizza> getPizzaByName(String name) { return pizzaRepository.findByName(name); }

    public void deletePizza(Pizza pizza) { pizzaRepository.delete(pizza); }

    public Pizza updatePizza(Pizza pizza) {
        Pizza p = pizzaRepository.findById(pizza.getId()).orElse(pizza);
        p.setCompositions(pizza.getCompositions());
        p.setPrices(pizza.getPrices());
        p.setABase(pizza.getABase());
        p.setAppearsInMenu(pizza.getAppearsInMenu());
        p.setName(pizza.getName());
        p.setPicture(pizza.getPicture());
        return pizzaRepository.save(p);
    }
}