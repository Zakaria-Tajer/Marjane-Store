package Marj.Servlet;

import Marj.Controller.AdminController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteAdmin", value = "/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminController adminController = new AdminController();

        if (request.getParameter("id") != null) {

            int id = Integer.parseInt(request.getParameter("id"));
            adminController.deleteAdminByids(id);
            response.sendRedirect(".");
        } else {
            System.out.println("error");
        }

    }
}
