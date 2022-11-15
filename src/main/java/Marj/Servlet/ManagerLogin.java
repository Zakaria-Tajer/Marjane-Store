package Marj.Servlet;

import Marj.Controller.AdminController;
import Marj.Controller.ManagerController;
import Marj.Data.AdminConst;
import Marj.Data.ManagerData;
import Marj.helper.HashPassword;
import entity.PromotionsEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerLogin", value = "/ManagerLogin")
public class ManagerLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

            HashPassword hashPassword = new HashPassword();
            ManagerData managerData = new ManagerData();
            ManagerController managerController = new ManagerController();

            managerController.getEmail(email);

            if (hashPassword.validPassword(password, ManagerData.getPassword())) {
                HttpSession session = request.getSession();

                List<PromotionsEntity> promotions =  managerController.getManagersPromo(ManagerData.getCityResponsableFor());
//                managerController.assignPromosData(promotions);
                ManagerData.setPromos(promotions);
                session.setAttribute("unique_id", ManagerData.getUniqueId());
                request.setAttribute("promotions",promotions);
                if (session.getAttribute("unique_id" ) != null) {
                    System.out.println(session.getAttribute("unique_id" ));
                    response.sendRedirect("./Views/Manager/dashboard.jsp");
                }
                response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);


            } else {
                System.out.println("Invalid password");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
