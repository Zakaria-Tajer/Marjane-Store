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
                session.setAttribute("countsAdmin", adminController.getNumbers());
                session.setAttribute("countsManager", adminController.getNumbersOfManagers());
                session.setAttribute("countsPromotions", adminController.countPromotions());
                session.setAttribute("countsNewAdmins", adminController.countNewAdmins());


                response.sendRedirect("./Views/Admin/dashboard.jsp");
                response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("./Views/Admin/dashboard.jsp");
//                dispatcher.forward(request, response);

            } else {
                System.out.println("Invalid password");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
