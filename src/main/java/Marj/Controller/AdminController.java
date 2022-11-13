package Marj.Controller;

import Marj.Data.AdminsCount;
import Marj.Model.AdminModel.Admin;
import entity.AdminEntity;

import java.sql.SQLException;
import java.util.List;


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


    public List<AdminEntity> getAllAdmins() {
        return admin.getAdmins();
    }
    public List<AdminEntity> getAllAdminsCenters() {
        return admin.getListAdminsCenters();
    }

    public int checkAdminAssgind(int adminId) {
        return admin.checkIfAdminIsAlreadyAssigned(adminId);
    }


    public String getLoginAdmin(String email, String password) {
        return admin.loginAdmin(email, password);
    }


    public int getNumbers() {
        return admin.countAdmin();
    }

    public int getNumbersOfManagers() {
        return admin.countManagers();
    }

    public int countPromotions() {
        return admin.countPromotions();
    }

    public int countNewAdmins() {
        return admin.countNewAdmins();
    }
    public void deleteAdminByids(int adminId) {
         admin.deleteAdminById(adminId);
    }


}
