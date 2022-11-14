package Marj.Servlet;

import Marj.Controller.CategorieController;
import Marj.Controller.PromotionsController;
import Marj.helper.UUIDs;
import entity.CategoryEntity;
import entity.CentersEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreatePromotions", value = "/CreatePromotions")
public class CreatePromotions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PromotionsController promotionsController = new PromotionsController();
        CategorieController categorieController = new CategorieController();
        UUIDs uuiDs = new UUIDs();
        HttpSession session = request.getSession();

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int reduction = Integer.parseInt(request.getParameter("reduction"));
        int centerId = Integer.parseInt(request.getParameter("centerId"));
        int stocks = Integer.parseInt(request.getParameter("stocks"));


        List<CategoryEntity> categories = categorieController.getCategory();

        List<CategoryEntity> filteredList = categories.stream().filter(category -> category.getCategoryId() == categoryId).collect(Collectors.toList());

        String categoryName = "";
        for (CategoryEntity categoryEntity : filteredList) {
            categoryName = categoryEntity.getCategoryName();
        }

        if (categoryName.equals("multimedia") && reduction > 50) {
            session.setAttribute("multimediaError", "Reduction amount cant be more than 50%");
        } else {
            session.setAttribute("multimediaSuccess", "success");

        }

        System.out.println(reduction + " " + centerId + " " + stocks + " " + categoryId + " " + uuiDs.uuid() + " " + "waiting");
        promotionsController.generateAPromotions(reduction, centerId,  stocks, categoryId, uuiDs.uuid(), "waiting", LocalDate.now());


        response.sendRedirect("./Views/SubAdmin/MakePromotions.jsp");


    }
}
