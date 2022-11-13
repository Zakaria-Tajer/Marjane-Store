package Marj.Servlet;

import Marj.Controller.AdminController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminsCounter", value = "/dashboard")
public class AdminsCounter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        AdminController adminController = new AdminController();

        System.out.println("hello");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("error", "2");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
//        dispatcher.forward(request, response);
        request.getRequestDispatcher("/Views/Admin/dashboard.jsp").forward(request, response);
        response.sendRedirect(".");
    }
}
