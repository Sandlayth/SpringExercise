package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.products.Menu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void createMenu() {
        Menu m = new Menu("Menu double", true, true);
        m = menuService.saveMenu(m);
        Assert.assertNotNull(m);
        menuService.deleteMenu(m);
    }

    @Test
    public void getMenus() {
        Assert.assertNotNull(menuService.getMenus());
    }

    @Test
    public void updateMenu() {
        Menu m = new Menu("Menu du soir", true, false);
        m = menuService.saveMenu(m);
        m.setName("Menu du matin");
        m = menuService.updateMenu(m);
        Assert.assertEquals(menuService.getMenuById(m.getId()).getName(), m.getName());
        menuService.deleteMenu(m);
    }

    @Test
    public void deleteMenu() {
        Menu m = new Menu("Menu pas rentable", true, false);
        m = menuService.saveMenu(m);
        menuService.deleteMenu(m);
        Assert.assertNull(menuService.getMenuById(m.getId()));
    }

}
