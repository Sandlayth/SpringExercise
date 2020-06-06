package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.entity.PriceType;
import com.sandlayth.fastfood.entity.Size;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTest {
    @Autowired
    private PriceService priceService;
    @Autowired
    private SizeService sizeService;

    @Test
    public void createPrice() {
        Size size = new Size("XL");
        size = sizeService.saveSize(size);
        Price p = new Price(PriceType.DELIVERY, size, 3.00);
        p = priceService.savePrice(p);
        Assert.assertNotNull(p);
        priceService.deletePrice(p);
        sizeService.deleteSize(size);
    }

    @Test
    public void getPrices() {
        Assert.assertNotNull(priceService.getPrices());
    }


    @Test
    public void updatePrice() {
        Size size = new Size("XL");
        size = sizeService.saveSize(size);
        Price p = new Price(PriceType.DELIVERY, size, 3.00);
        p = priceService.savePrice(p);
        p.setPrice(5.00);
        p = priceService.updatePrice(p);
        Assert.assertEquals(priceService.getPriceById(p.getId()).getPrice(), p.getPrice());
        priceService.deletePrice(p);
        sizeService.deleteSize(size);

    }

    @Test
    public void deletePrice() {
        Size size = new Size("XL");
        size = sizeService.saveSize(size);
        Price p = new Price(PriceType.DELIVERY, size, 3.00);
        p = priceService.savePrice(p);
        priceService.deletePrice(p);
        Assert.assertNull(priceService.getPriceById(p.getId()));
        sizeService.deleteSize(size);
    }

}
