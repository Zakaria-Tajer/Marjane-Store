package Marj.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uniqueId = (String) request.getSession().getAttribute("uniqueId");

        if(uniqueId != null) {
            System.out.println(request.getSession().getAttribute("uniqueId"));
            request.getSession().removeAttribute("uniqueId");
        }else {
            System.out.println("all ready removed");
        }
    }
}
