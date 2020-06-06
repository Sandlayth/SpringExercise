package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.products.Menu;
import com.sandlayth.fastfood.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu saveMenu(Menu menu) { return menuRepository.save(menu); }
    public List<Menu> saveMenus(List<Menu> menus) { return menuRepository.saveAll(menus); }

    public List<Menu> getMenus() { return menuRepository.findAll(); }
    public Menu getMenuById(Long id) { return menuRepository.findById(id).orElse(null); }

    public void deleteMenu(Menu menu) { menuRepository.delete(menu);}

    public Menu updateMenu(Menu menu) {
        Menu m = menuRepository.findById(menu.getId()).orElse(menu);
        m.setPrices(menu.getPrices());
        m.setABase(menu.getABase());
        m.setAppearsInMenu(menu.getAppearsInMenu());
        m.setName(menu.getName());
        m.setPicture(menu.getPicture());
        m.setProducts(menu.getProducts());
        return menuRepository.save(m);
    }

}
