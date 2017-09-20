package com.skcc.mndt.seat.common.menu.repository;

import com.skcc.mndt.seat.model.Menu;

import java.util.List;

public interface MenuRepositorySearch {
    List<Menu> getSubMenu(Long parentMenuId);
}
