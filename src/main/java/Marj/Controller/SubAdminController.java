package Marj.Controller;

import Marj.Model.SubAdmin.SubAdmin;
import entity.CentersEntity;

import java.util.List;

public class SubAdminController {

    SubAdmin subAdmin = new SubAdmin();

    public void createdManagers(String email, String password, String uniqueId, int cityResponsableFor) {

        subAdmin.createMangers(email, password, uniqueId, cityResponsableFor);
    }

    public List<CentersEntity> cityMangersRespo() {
        return subAdmin.getCityForManagers();
    }

}
