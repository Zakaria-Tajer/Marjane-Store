package Marj;

import Marj.Controller.AdminController;
import Marj.Controller.CategorieController;
import Marj.Controller.PromotionsController;
import Marj.Controller.SubAdminController;
import Marj.Data.AdminConst;
import Marj.Model.SubAdmin.SubAdmin;
import Marj.helper.HashPassword;
import Marj.helper.UUIDs;
import entity.CategoryEntity;
import entity.CentersEntity;
import entity.PromotionsEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class Admin implements Marj.Interfaces.Admin {
    String uniqueID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

    HashPassword hashPassword = new HashPassword();
    AdminController adminController = new AdminController();
    SubAdminController subAdminController = new SubAdminController();

    PromotionsController promotionsController = new PromotionsController();
    CategorieController categorieController = new CategorieController();

    public void general() throws SQLException {
        Scanner inputs = new Scanner(System.in);
        AdminConst adminConst = new AdminConst();

        System.out.println("Enter your email: ");
        String email = inputs.nextLine();

        adminController.getEmail(email);

        System.out.println("Enter your password: ");
        String password = inputs.nextLine();

        boolean isCorrect = false;
        do {
            if (hashPassword.validPassword(password, adminConst.getPassword())) {
                isCorrect = true;
                System.out.println("Password is correct");
            } else {
                System.out.println("password1 is not correct");
                inputs.nextLine();
            }
        } while (!isCorrect);

        System.out.println("1: Create Department manager");
        System.out.println("2:  List of promotions");
        System.out.println("3: Make a promotion");

        int choice = inputs.nextInt();

        switch (choice) {
            case 1:
                createDepartmentManager();
                break;
            case 2:
                listOfPromotions();
                break;
            case 3:
                makeAPromotion();
                break;
        }

    }

    public void createDepartmentManager() {
        Scanner input = new Scanner(System.in);
        SubAdminController subAdminController = new SubAdminController();
        List<CentersEntity> c = subAdminController.cityMangersRespo();

        System.out.println("Enter manager email:");
        String managerEmail = input.next();
        System.out.println("Enter manager password:");
        String managerPassword = input.next();

        System.out.println("Enter center wanted to place a manager in");
        for (CentersEntity entity : c) {
            System.out.println(entity.getCenterId() + ": " + entity.getCity());
        }
        int choice = input.nextInt();

        subAdminController.createdManagers(managerEmail, managerPassword, uniqueID, choice);
    }


    public void listOfPromotions() {
        Scanner input = new Scanner(System.in);
        List<PromotionsEntity> promo = promotionsController.getAllPromotions();

        for (PromotionsEntity p : promotionsController.getAllPromotions()) {
            System.out.println(p.getPromotionId() + " " + p.getReduction() + " " + p.getStock() + " " + p.getCategoryId());
        }

        System.out.println("1: for list of approved promotions");
        System.out.println("2: for list of waiting promotions");
        int listPromotionsNum = input.nextInt();

        switch (listPromotionsNum) {
            case 1: {
                System.out.println("dedeed");
                for (PromotionsEntity promotions : promosGetter(promo, "!")) {
                    System.out.println(promotions.getPromotionId() + ":" + " " + promotions.getPromotionUniqueId() + " " + promotions.getStatus());
                }
                break;
            }
            case 2: {
                for (PromotionsEntity promotions : promosGetter(promo, "")) {
                    System.out.println(promotions.getPromotionId() + ":" + " " + promotions.getPromotionUniqueId() + " " + promotions.getStatus());
                }
                break;
            }
        }
    }


    public void makeAPromotion() {
        Scanner scanner = new Scanner(System.in);
        SubAdminController subAdminController = new SubAdminController();
        UUIDs uuiDs = new UUIDs();
        List<CentersEntity> centers = subAdminController.cityMangersRespo();

        for (CategoryEntity c : categorieController.getCategory()) {
            System.out.println(c.getCategoryId() + ": " + c.getCategoryName());
        }
        System.out.println("Enter the category number: ");
        int categoryChoice = scanner.nextInt();

        List<CategoryEntity> categoryList = categorieController.getCategory().stream().filter(category -> category.getCategoryId() == categoryChoice).collect(Collectors.toList());

        int categoryId = 0;
        String categoryName = null;
        for (CategoryEntity c : categoryList) {
            categoryName = c.getCategoryName();

            categoryId = c.getCategoryId();
        }


        if(categoryName.equals("multimedia")){

        }

            System.out.println("Enter reduction %: ");
            int reduction;
        do {

            System.out.println("please select a reduction less than 50%");
            reduction = scanner.nextInt();
        } while (reduction > 50);

        System.out.println("Select center: ");
        for (CentersEntity c : centers) {
            System.out.println(c.getCenterId() + ":" + " " + c.getCity());
        }

        int centerId = scanner.nextInt();
        List<CentersEntity> filterdCenters = centers.stream().filter(center -> center.getCenterId() == centerId).collect(Collectors.toList());
        int centerFilteredId = 0;
        for (CentersEntity c : filterdCenters) {
            centerFilteredId = c.getCenterId();
        }

        System.out.println("Enter stock units : ");
        int stock = scanner.nextInt();

        if (stock != 0)
            promotionsController.generateAPromotions(reduction, centerFilteredId, stock, categoryId, uuiDs.uuid(), "waiting");

    }


    public List<PromotionsEntity> promosGetter(List<PromotionsEntity> promo, String sign) {
        if (sign.equals("!"))
            return promo.stream().filter(c -> !c.getStatus().equals("waiting")).collect(Collectors.toList());
        else return promo.stream().filter(c -> c.getStatus().equals("waiting")).collect(Collectors.toList());
    }

}
