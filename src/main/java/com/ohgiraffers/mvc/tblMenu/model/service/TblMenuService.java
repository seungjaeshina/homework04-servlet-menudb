package com.ohgiraffers.mvc.tblMenu.model.service;


import com.ohgiraffers.mvc.tblMenu.model.dao.MenuMapper;
import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class TblMenuService {

    private static MenuMapper menuMapper;

    public static MenuDTO selectOneMenuByCode(String menuCode) {

        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession = " + sqlSession);

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO selectMenu = menuMapper.selectOneMenuByCode(menuCode);

        sqlSession.close();
        return selectMenu;
    }

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public int insetMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menuDTO);
        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public int updateMenu(MenuDTO menuDTO) {

        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(menuDTO);
        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public int deleteMenu(String menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menuCode);
        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
