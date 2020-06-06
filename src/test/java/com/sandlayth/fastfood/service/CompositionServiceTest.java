package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.entity.PriceType;
import com.sandlayth.fastfood.entity.Size;
import com.sandlayth.fastfood.entity.products.Composition;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompositionServiceTest {
    @Autowired
    private CompositionService compositionService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private SizeService sizeService;

    @Test
    public void createComposition() {
        Composition c = new Composition("Pâton", true, true);
        c = compositionService.saveComposition(c);
        Assert.assertNotNull(c);
        compositionService.deleteComposition(c);
    }

    @Test
    public void createCompleteComposition() {
        // String name, Boolean appearsInMenu, Boolean isABase, List< Price > prices, Long quantity, Long cost
        Size size = new Size("XL");
        size = sizeService.saveSize(size);
        Price price = new Price(PriceType.DELIVERY, size, 3.00);
        price = priceService.savePrice(price);
        Composition c = new Composition("Mozzarella", true, false);
        c.setPrices(Arrays.asList(price));
        c.setQuantity(0.5);
        c.setCost(1.3);
        c = compositionService.saveComposition(c);

        Assert.assertNotNull(c);

        priceService.deletePrice(price);
        sizeService.deleteSize(size);
        compositionService.deleteComposition(c);
    }

    @Test
    public void getCompositions() {
        Assert.assertNotNull(compositionService.getCompositions());
    }

    @Test
    public void updateComposition() {
        Composition c = new Composition("Concentré de tomate", true, false);
        c = compositionService.saveComposition(c);
        c.setName("Tomate concentrée");
        c = compositionService.updateComposition(c);
        Assert.assertEquals(compositionService.getCompositionById(c.getId()).getName(), c.getName());
        compositionService.deleteComposition(c);
    }

    @Test
    public void deleteComposition() {
        Composition c = new Composition("Fromage qui pue", true, false);
        c = compositionService.saveComposition(c);
        compositionService.deleteComposition(c);
        Assert.assertNull(compositionService.getCompositionById(c.getId()));
    }

}
