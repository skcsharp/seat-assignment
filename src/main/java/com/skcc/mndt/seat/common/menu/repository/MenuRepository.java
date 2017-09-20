package com.skcc.mndt.seat.common.menu.repository;

import com.skcc.mndt.seat.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositorySearch {
}
