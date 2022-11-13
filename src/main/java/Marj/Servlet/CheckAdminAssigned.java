package Marj.Servlet;

import Marj.Controller.AdminController;
import Marj.helper.UUIDs;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckAdminAssigned", value = "/CheckAdminAssigned")
public class CheckAdminAssigned extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminController adminController = new AdminController();
        System.out.println(request.getParameter("assignedAdmin") + "  " +  request.getParameter("city"));
        int adminId = Integer.parseInt(request.getParameter("assignedAdmin"));

        String city = request.getParameter("city");
        UUIDs uuid = new UUIDs();
        int isAssigned = adminController.checkAdminAssgind(adminId);


        HttpSession session = request.getSession();

        if (isAssigned == 0) {
            try {
                adminController.assignAdmins(adminId, city, uuid.uuid());
            session.setAttribute("assignedAdminSuccess", "admin already assigned");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {

            session.setAttribute("assignedAdminError", "admin already assigned");
        }

        response.sendRedirect("./Views/Admin/AssignSubAdmin.jsp");

    }
}
