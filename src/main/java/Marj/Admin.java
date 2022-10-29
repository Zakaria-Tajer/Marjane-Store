package Marj;

import Marj.Controller.AdminController;
import Marj.Controller.CategorieController;
import Marj.Controller.PromotionsController;
import Marj.Controller.SubAdminController;
import Marj.Data.AdminConst;
import Marj.Data.ManagerData;
import Marj.Mailer.Mails;
import Marj.Model.SubAdmin.SubAdmin;
import Marj.helper.HashPassword;
import Marj.helper.UUIDs;
import entity.CategoryEntity;
import entity.CentersEntity;
import entity.ManagersEntity;
import entity.PromotionsEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    Mails mails = new Mails();
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
        CategorieController categoryController = new CategorieController();
        ManagerData managerData = new ManagerData();
        List<CentersEntity> c = subAdminController.cityMangersRespo();
        List<CategoryEntity> categories = categoryController.getCategory();

        System.out.println("Enter manager email:");
        String managerEmail = input.next();
        System.out.println("Enter manager password:");
        String managerPassword = input.next();

        System.out.println("Enter center wanted to place a manager in");
        for (CentersEntity entity : c) {
            System.out.println(entity.getCenterId() + ": " + entity.getCity());
        }
        int choice = input.nextInt();

        System.out.println("Enter category responsable for: ");
        for (CategoryEntity entity : categories) {
            System.out.println(entity.getCategoryId() + ": " + entity.getCategoryName());
        }

        int category = input.nextInt();


//                if manager is inserted hash password after and update it


//        System.out.println(subAdminController.getManagerId(managerEmail).get(0));
//        System.out.println("New Manager Id: " + newManagerId);


        subAdminController.createdManagers(managerEmail, managerPassword, uniqueID, choice, category);
        String msg = mails.emailSender(managerEmail, managerEmail, managerPassword);


        if (msg.equals("Message sent")) {
            System.out.println(msg + "Message has been sent");
//            subAdminController.updateManagerPasswords(hashPassword.hashPassword(managerPassword), newManagerId);
        }else {
            System.out.println(msg + "Message has been sent or errrrrror");
        }
    }


    public void listOfPromotions() {
        Scanner input = new Scanner(System.in);
        List<PromotionsEntity> promo = promotionsController.getAllPromotions();

        System.out.println("1: for list of approved promotions");
        System.out.println("2: for list of waiting promotions");
        System.out.println("3: for list of last promotions");
        System.out.println("4: for list of today promotions");
        int listPromotionsNum = input.nextInt();

        switch (listPromotionsNum) {
            case 1: {
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
            case 3: {
                for (PromotionsEntity promotions : promotionsGetterFilteredByDate(promo, "Today")) {
                    System.out.println(promotions.getPromotionId() + ":" + " " + promotions.getPromotionUniqueId() + " " + promotions.getStatus() + " " + promotions.getPromotionExpiringDate());
                }
                break;
            }
            case 4: {
                for (PromotionsEntity promotions : promotionsGetterFilteredByDate(promo, "")) {
                    System.out.println(promotions.getPromotionId() + ":" + " " + promotions.getPromotionUniqueId() + " " + promotions.getStatus() + " " + promotions.getPromotionExpiringDate());
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


        assert categoryName != null;
        if (categoryName.equals("multimedia")) {
            System.out.println("Reduction amount cant be more than 50%");
        }

        System.out.println("Enter reduction %: ");
        int reduction = scanner.nextInt();
        int reductionTwo;

        int tempReduction;

        do {
            System.out.println("please select a reduction less than 50%");
            reductionTwo = scanner.nextInt();

        } while (reduction <= 50);

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


        if (stock != 0) {
            if (reduction > 50) tempReduction = reductionTwo;
            else tempReduction = reduction;

            promotionsController.generateAPromotions(tempReduction, centerFilteredId, stock, categoryId, uuiDs.uuid(), "waiting");
        }

    }


    public List<PromotionsEntity> promosGetter(List<PromotionsEntity> promo, String sign) {
        if (sign.equals("!"))
            return promo.stream().filter(c -> !c.getStatus().equals("waiting")).collect(Collectors.toList());
        else return promo.stream().filter(c -> c.getStatus().equals("waiting")).collect(Collectors.toList());
    }

    public List<PromotionsEntity> promotionsGetterFilteredByDate(List<PromotionsEntity> promo, String date) {

        if (date.equals("Today"))
            return promo.stream().filter(c -> String.valueOf(c.getPromotionExpiringDate()).equals(String.valueOf(java.time.LocalDate.now()))).collect(Collectors.toList());
        else
            return promo.stream().filter(c -> !String.valueOf(c.getPromotionExpiringDate()).equals(String.valueOf(java.time.LocalDate.now()))).collect(Collectors.toList());
    }

}
