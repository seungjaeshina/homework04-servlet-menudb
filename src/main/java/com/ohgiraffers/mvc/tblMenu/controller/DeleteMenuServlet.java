package com.ohgiraffers.mvc.tblMenu.controller;

import com.ohgiraffers.mvc.tblMenu.model.service.TblMenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tbl_menu/delete")
public class DeleteMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String menuCode = req.getParameter("menuCode");

        TblMenuService tblMenuService = new TblMenuService();
        int result = tblMenuService.deleteMenu(menuCode);

        if (result > 0){
            resp.sendRedirect(req.getContextPath()+ "/tbl_menu/list");
        }else{
            req.setAttribute("message" ,"메뉴 정보 삭제에 실패하셨습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
