package Marj;

import Marj.Controller.AdminController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String uniqueID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    public static int menu(){
        System.out.println("1: Login as a General Administrator");
        System.out.println("2: Login as a Admin");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws SQLException {
        AdminController adminController = new AdminController();
        GeneralAdmin generalAdmin = new GeneralAdmin();
        Admin admin = new Admin();
        switch (menu()){
            case 1: generalAdmin.general();
                break;
            case 2: admin.general();
            break;

        }

    }

    public void createAdminForStore(){

    }








}
