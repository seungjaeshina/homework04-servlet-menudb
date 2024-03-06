package com.ohgiraffers.mvc.tblMenu.controller;

import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;
import com.ohgiraffers.mvc.tblMenu.model.service.TblMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tbl_menu/select")
public class SelectOneMenuByServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuCode = req.getParameter("menuCode");
        System.out.println("menuCode = " + menuCode);

        TblMenuService tblMenuService = new TblMenuService();
        MenuDTO selectedMenu = TblMenuService.selectOneMenuByCode(menuCode);
        System.out.println("selectedMenu = " + selectedMenu);

        String path = " ";
        if (selectedMenu != null) {
            path = "/WEB-INF/views/menudb/showMenuInfo.jsp";
            req.setAttribute("selectedMenu", selectedMenu);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 코드를 가진 메뉴는 없습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
