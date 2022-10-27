package Marj.Controller;

import Marj.Data.AdminConst;
import Marj.Model.AdminModel.Admin;
import entity.AdminEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AdminController {

    Admin admin = new Admin();

    public void createAdmins(String email, String password, String uniqueId) throws SQLException {
        admin.createAdmin(email, password, uniqueId);
    }

    public void getEmail(String email) throws SQLException {
        admin.getAdminEmail(email);
    }

    public void assignAdmins(int admin_respo, String city, String center_unique_id) throws SQLException {
        admin.assignAdminToAStore(admin_respo, city, center_unique_id);
    }


    public List<AdminEntity> getAllAdmins(){
        return admin.getAdmins();
    }

    public int checkAdminAssgind(int adminId){
        return admin.checkIfAdminIsAlreadyAssigned(adminId);
    }



}
