package Marj.Controller;

import Marj.Model.SubAdmin.SubAdmin;
import entity.CentersEntity;
import entity.ManagersEntity;

import java.util.List;

//import static Marj.Data.AdminConst.email;

public class SubAdminController {

    SubAdmin subAdmin = new SubAdmin();

    public void createdManagers(String email, String password, String uniqueId, int cityResponsableFor, int category) {

        subAdmin.createMangers(email, password, uniqueId, cityResponsableFor, category);
    }

    public List<CentersEntity> cityMangersRespo() {
        return subAdmin.getCityForManagers();
    }

    public void updateManagerPasswords(String hashedPassword, int managerId){
        subAdmin.updatePassword(hashedPassword, managerId);
    }

    public int getManagerId(String email){
        return subAdmin.getManagerId(email);
    }

}
