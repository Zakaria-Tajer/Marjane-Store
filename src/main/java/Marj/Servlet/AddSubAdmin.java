package Marj.Servlet;

import Marj.Controller.AdminController;
import Marj.helper.UUIDs;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddSubAdmin", value = "/AddSubAdmin")
public class AddSubAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminController adminController = new AdminController();
        UUIDs uuiDs = new UUIDs();
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if(email != null && password != null ){
            try {
                adminController.createAdmins(email, password,uuiDs.uuid());
                response.sendRedirect(".");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            session.setAttribute("error", "Please enter a all information");
        }



    }
}
