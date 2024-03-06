package com.ohgiraffers.mvc.tblMenu.controller;

import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;
import com.ohgiraffers.mvc.tblMenu.model.service.TblMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tbl_menu/list")
public class SelectAllMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TblMenuService tblMenuService = new TblMenuService();
        List<MenuDTO> menuList = tblMenuService.selectAllMenu();

        String path = " ";
        if (menuList != null && !menuList.isEmpty()){
            path = "/WEB-INF/views/menudb/menuList.jsp";
            req.setAttribute("menuList", menuList);
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message","메뉴 목록이 조회되지 않습니다!");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
