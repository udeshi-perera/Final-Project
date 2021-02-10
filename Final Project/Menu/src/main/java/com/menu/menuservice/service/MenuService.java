package com.menu.menuservice.service;

import commonproject.model.menu.Menu;

public interface MenuService {

    Menu save(Menu menu);

    Menu update(Menu menu);

    Menu findMenuByFoodCode(String code);

    void delete(Integer id);

    Menu fetch(int id);
}
