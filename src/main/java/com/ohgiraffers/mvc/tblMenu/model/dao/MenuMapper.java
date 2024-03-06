package com.ohgiraffers.mvc.tblMenu.model.dao;

import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {



    MenuDTO selectOneMenuByCode(String menuCode);

    List<MenuDTO> selectAllMenu();


    int insertMenu(MenuDTO menuDTO);

    int updateMenu(MenuDTO menuDTO);

    int deleteMenu(String menuCode);
}
