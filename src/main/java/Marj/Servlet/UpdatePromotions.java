package Marj.Servlet;

import Marj.Controller.PromotionsController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdatePromotions", value = "/UpdatePromotions")
public class UpdatePromotions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PromotionsController promotionsController = new PromotionsController();
        int promotionId = Integer.parseInt(request.getParameter("promotionsId"));
        String status = request.getParameter("promotionsStatus");

        HttpSession session = request.getSession();

        String promotionsMsg  = promotionsController.updatePromotionsByManager(promotionId, status);

        if (promotionsMsg.equals("updated")) {
            session.setAttribute("successUpdate", promotionsMsg);
            response.sendRedirect("./Views/Manager/EditPromotions.jsp");
        }else {
            session.setAttribute("errorMsg", "Error while updating promotion");
        }
        System.out.println(promotionId + ": " + status);
    }
}
