package com.skcc.mndt.seat.common.menu;

import com.skcc.mndt.seat.common.menu.repository.MenuRepository;
import com.skcc.mndt.seat.model.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class MenuController {
    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @PostMapping("/common/menu")
    public ResponseEntity<Menu> registerMenu(@Valid @RequestBody Menu menu) {
        return ResponseEntity.ok(menuRepository.save(menu));
    }

    @GetMapping("/common/menu/{menuId}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long menuId) {
        return ResponseEntity.ok(menuRepository.findOne(menuId));
    }

    @PutMapping("/common/menu")
    public ResponseEntity<Menu> setMenu(@Valid @RequestBody Menu menu) {
        Menu fetchedMenu = menuRepository.findOne(menu.getId());
        fetchedMenu.setName(menu.getName());
        fetchedMenu.setParentId(menu.getParentId());
        fetchedMenu.setUri(menu.getUri());

        return ResponseEntity.ok(menuRepository.save(menu));
    }

    @DeleteMapping("/common/menu/{menuId}")
    public ResponseEntity<Menu> removeMenu(@PathVariable Long menuId) {
        Menu fetchedMenu = menuRepository.findOne(menuId);
        menuRepository.delete(menuId);
        return ResponseEntity.ok(fetchedMenu);
    }

    @GetMapping("/common/menu")
    public ResponseEntity<List<Menu>> getMenu() {
        return ResponseEntity.ok(menuRepository.findAll());
    }

    @GetMapping("/common/menu/{parentMenuId}/submenu")
    public ResponseEntity<List<Menu>> getSubMenu(@PathVariable Long parentMenuId) {
        return ResponseEntity.ok(menuRepository.getSubMenu(parentMenuId));
    }
}
