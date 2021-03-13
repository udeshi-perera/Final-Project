package com.menu.menuservice.service.Impl;

import com.menu.menuservice.repository.MenuRepository;
import com.menu.menuservice.service.MenuService;
import commonproject.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Override
    public Menu save(Menu menu) {
        System.out.println(menu);
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        menu.setId(menu.getId());
        Menu updateMenu = menuRepository.save(menu);
        return updateMenu;
    }

    @Override
    public List<Menu> findMenuByFoodCode(String code) {
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

    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }
}
