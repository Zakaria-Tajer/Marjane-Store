package Marj.Servlet;

import Marj.Controller.AdminController;
import Marj.Data.AdminConst;
import Marj.helper.HashPassword;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminLogin", value = "/AdminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            HashPassword hashPassword = new HashPassword();
            AdminConst adminConst = new AdminConst();
            AdminController adminController = new AdminController();

            adminController.getEmail(email);

            if (hashPassword.validPassword(password, adminConst.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("id", adminConst.getUniqueId());
                response.sendRedirect( "./Views/Admin/dashboard.jsp");
            } else {
                System.out.println("Invalid password");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
