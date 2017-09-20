package com.skcc.mndt.seat.common.menu.repository;

import com.querydsl.jpa.JPQLQuery;
import com.skcc.mndt.seat.model.Menu;
import com.skcc.mndt.seat.model.QMenu;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepositoryImpl extends QueryDslRepositorySupport implements MenuRepositorySearch {
    public MenuRepositoryImpl() {
        super(Menu.class);
    }

    @Override
    public List<Menu> getSubMenu(Long parentMenuId) {
        QMenu menu = QMenu.menu;
        JPQLQuery jpqlQuery = from(menu).where(menu.parentId.eq(parentMenuId));
        return getQuerydsl().applyPagination(null, jpqlQuery).fetch();
    }
}
