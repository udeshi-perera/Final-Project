package com.menu.menuservice.service;

import commonproject.model.menu.Menu;

import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    Menu update(Menu menu);

    List<Menu> findMenuByFoodCode(String code);

    void delete(Integer id);

    Menu fetch(int id);

    List<Menu> findAllMenu();
}
