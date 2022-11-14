package Marj.Servlet;

import Marj.Controller.SubAdminController;
import Marj.Mailer.Mails;
import Marj.helper.HashPassword;
import Marj.helper.UUIDs;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateManager", value = "/CreateManager")
public class CreateManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        SubAdminController subAdminController = new SubAdminController();
        HashPassword hashPassword = new HashPassword();
        UUIDs uuiDs = new UUIDs();
        Mails mails = new Mails();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int cityId = Integer.parseInt(request.getParameter("CityID"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        String hashedPassword = hashPassword.hashPassword(password);
        subAdminController.createdManagers(email, hashedPassword, uuiDs.uuid(), cityId, categoryId);

        String msg = mails.emailSender(email, email, password);

        if (msg.equals("Message sent")) {
            session.setAttribute("SuccessEmail", "Email sent successfully");
            System.out.println(msg + "Message has been sent");
            response.sendRedirect("./View/SubAdmin/CreateManager.jsp");
        }else {
            session.setAttribute("ErrorEmail", "Email error");
            System.out.println(msg + "Message has not been sent error");
        }

    }
}
