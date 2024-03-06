package com.ohgiraffers.mvc.tblMenu.controller;

import com.ohgiraffers.mvc.tblMenu.model.dto.MenuDTO;
import com.ohgiraffers.mvc.tblMenu.model.service.TblMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tbl_menu/update")
public class UpdateMenuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String menuCode = req.getParameter("menuCode");
        String menuName = req.getParameter("menuName");

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuCode(Integer.parseInt(menuCode));
        menuDTO.setMenuName(menuName);

        TblMenuService tblMenuService = new TblMenuService();
        int  result = tblMenuService.updateMenu(menuDTO);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/tbl_menu/select?menuCode=" + menuCode);
        }else {
            req.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp);
        }
    }
}
