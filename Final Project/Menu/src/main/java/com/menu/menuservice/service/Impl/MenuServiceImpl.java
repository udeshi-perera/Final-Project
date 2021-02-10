package com.menu.menuservice.service.Impl;

import com.menu.menuservice.repository.MenuRepository;
import com.menu.menuservice.service.MenuService;
import commonproject.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        menu.setId(menu.getId());
        Menu updateMenu = menuRepository.save(menu);
        return updateMenu;
    }

    @Override
    public Menu findMenuByFoodCode(String code) {
        return menuRepository.findByCode(code);
    }

    @Override
    public void delete(Integer id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Menu fetch(int id) {
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        return optionalMenu.get();
    }
}
