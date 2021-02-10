package com.menu.menuservice.controller;

import com.menu.menuservice.service.MenuService;
import commonproject.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public Menu save(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.PUT)
    public ResponseEntity<Menu> update(@RequestBody Menu menu) {
        Menu updateMenu = menuService.update(menu);
        return ResponseEntity.ok().body(updateMenu);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Menu viewByMenuCode(@RequestParam(value = "code") String code) {
        return menuService.findMenuByFoodCode(code);
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteItem(@PathVariable Integer id) {
        try {
            menuService.delete(id);
            return ResponseEntity.ok().body("Item deleted Successfully");
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item for the given code");
        }
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public ResponseEntity fetch(@PathVariable(value = "id") int id) {
        try {
            Menu menu = menuService.fetch(id);
            return ResponseEntity.status(HttpStatus.OK).body(menu);
        } catch (NoSuchElementException noSuchElementException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu Id is not existing");
        }
    }
}
