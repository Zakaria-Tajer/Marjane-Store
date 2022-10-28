package Marj;

import Marj.Controller.AdminController;
import Marj.Data.AdminConst;
import Marj.Mailer.Mails;
import Marj.helper.HashPassword;
import entity.AdminEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class GeneralAdmin implements Marj.Interfaces.GeneralAdmin {
    String uniqueID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    HashPassword hashPassword = new HashPassword();
    AdminController adminController = new AdminController();

    public void general() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: to Login");

        int i = scanner.nextInt();

        if (i == 1) {
            Scanner input = new Scanner(System.in);

            AdminConst adminConst = new AdminConst();

            System.out.println("Enter your email: ");
            String email = input.nextLine();

            adminController.getEmail(email);

            System.out.println("Enter your password: ");
            String password = input.nextLine();

            boolean isCorrect = false;
            do {
                if (hashPassword.validPassword(password, adminConst.getPassword())) {
                    isCorrect = true;
                    System.out.println("Password is correct");
                } else {
                    System.out.println("password1 is not correct");
                    input.nextLine();
                }
            } while (!isCorrect);

            System.out.println("1: Create admin");
            System.out.println("2: assign an admin to store");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    createAdminForStore();
                    break;
                case 2:
                    assignAnAdminToAStore();
                    break;
            }
            createAdminForStore();
        }

    }


    public void createAdminForStore() throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter email address for the admin");
        String adminEmail = input.nextLine();
        System.out.println("Enter email address for the admin");
        String password = input.nextLine();

        adminController.createAdmins(adminEmail, password, uniqueID);

        System.out.println("admin created");
    }

    public void assignAnAdminToAStore() throws SQLException {
        Scanner input = new Scanner(System.in);
        List<AdminEntity> p = adminController.getAllAdmins();
        Mails mail = new Mails();
        HashPassword hashPassword = new HashPassword();

        for (AdminEntity admin : p) {
            System.out.println(admin.getAdminId() + ":" + " " + admin.getEmail());
        }
        System.out.println("Enter the admin id to assign");
        int adminId = input.nextInt();
        int isAssigned = adminController.checkAdminAssgind(adminId);

        if (isAssigned == 0) {

            System.out.println("Enter the city the admin gonna be responsible of");
            String city = input.next();

            p.stream().filter(c -> c.getAdminId() == adminId).collect(Collectors.toList());

            int choosed = 0;
            String email = null;
            String password = null;
            for (AdminEntity admin : p) {
                choosed = admin.getAdminId();
                email = admin.getEmail();
                password = admin.getPassword();
                System.out.println(admin.getAdminId() + " " + admin.getEmail());
            }
            adminController.assignAdmins(choosed, city, uniqueID);

            System.out.println("Email is intialized");
            String message = mail.emailSender("zak.tajer@gmail.com", email, password);
            System.out.println("Email is sending....");

            if (message.equals("Message sent")) {
                System.out.println("Message sent");
//                after the email sent hashPassword and update it in db
//                String hashedPassword = hashPassword.hashPassword(password);
            }

        } else {
            System.out.println("admin is already assigned");
        }


    }


}



























