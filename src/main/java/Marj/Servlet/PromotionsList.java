package Marj.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PromotionsList", value = "/PromotionsList")
public class PromotionsList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int promotionSwitchId = Integer.parseInt(request.getParameter("promotions"));
        HttpSession session = request.getSession();


        switch (promotionSwitchId) {
            case 1: session.setAttribute("promotion", 1);
            break;
            case 2: session.setAttribute("promotion", 2);
            break;
            case 3: session.setAttribute("promotion", 3);
            break;
            case 4: session.setAttribute("promotion", 4);
            break;
        }

        response.sendRedirect("./Views/SubAdmin/PromotionsList.jsp");

    }
}
