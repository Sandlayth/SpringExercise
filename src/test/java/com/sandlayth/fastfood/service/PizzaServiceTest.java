package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.products.Pizza;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaServiceTest {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private CompositionService compositionService;

    @Test
    public void createPizza() {
        Pizza p = new Pizza("Pizza Napolitaine", true, false);
        p = pizzaService.savePizza(p);
        Assert.assertNotNull(p);
        pizzaService.deletePizza(p);
    }

    /*@Test
    public void createCompletePizza() {
        //String name, Boolean appearsInMenu, Boolean isABase, List< Price > prices, List< Composition > compositions
    }
    */

    @Test
    public void getPizzas() {
        Assert.assertNotNull(pizzaService.getPizzas());
    }

    @Test
    public void getPizzaByName() {
        Assert.assertNotNull(pizzaService.getPizzaByName("Pizza Napolitaine"));
    }

    @Test
    public void updatePizza() {
        Pizza p = new Pizza("Pizza Napolitaine", true, false);
        p = pizzaService.savePizza(p);
        p.setName("Pizza Margherita");
        p = pizzaService.updatePizza(p);
        Assert.assertEquals(pizzaService.getPizzaById(p.getId()).getName(), p.getName());
        pizzaService.deletePizza(p);
    }

    @Test
    public void deletePizza() {
        Pizza p = new Pizza("Pizza Napolitaine", true, false);
        p = pizzaService.savePizza(p);
        pizzaService.deletePizza(p);
        Assert.assertNull(pizzaService.getPizzaById(p.getId()));
    }

}
