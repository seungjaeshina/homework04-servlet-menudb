package com.ohgiraffers.mvc.tblMenu.controller;

import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;
import com.ohgiraffers.mvc.tblMenu.model.service.TblMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tbl_menu/insert")
public class InsertMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String menuName = req.getParameter("menuName");
        String menuPrice = req.getParameter("menuPrice");
        String categoryCode = req.getParameter("categoryCode");

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(Integer.parseInt(menuPrice));
        menuDTO.setCategoryCode(Integer.parseInt(categoryCode));
        System.out.println("menuDTO = " + menuDTO);

        TblMenuService tblMenuService = new TblMenuService();
        int result = tblMenuService.insetMenu(menuDTO);

        if (result > 0){
            resp.sendRedirect(req.getContextPath() + "/tbl_menu/list");

        }else {
            req.setAttribute("message", "신규 메뉴 등록에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }

    }
}