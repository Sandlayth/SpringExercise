package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Size;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SizeServiceTest {
    @Autowired
    private SizeService sizeService;

    @Test
    public void createSize() {
        Size s = new Size("XL");
        s = sizeService.saveSize(s);
        Assert.assertNotNull(s);
        sizeService.deleteSize(s);
    }

    @Test
    public void getSizes() {
        Assert.assertNotNull(sizeService.getSizes());
    }

    @Test
    public void updateSize() {
        Size s = new Size("XL");
        s = sizeService.saveSize(s);
        s.setName("L");
        s = sizeService.updateSize(s);
        Assert.assertEquals(sizeService.getSizeById(s.getId()).getName(), s.getName());
        sizeService.deleteSize(s);
    }

    @Test
    public void deleteSize() {
        Size s = new Size("XL");
        s = sizeService.saveSize(s);
        sizeService.deleteSize(s);
        Assert.assertNull(sizeService.getSizeById(s.getId()));
    }

}
