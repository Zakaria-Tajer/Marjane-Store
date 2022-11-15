package Marj.Controller;

import Marj.Model.Manager;
import entity.PromotionsEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerController {

    List<PromotionsEntity> promotions = new ArrayList<>();
    Manager manager = new Manager();

    public void getEmail(String email) throws SQLException {
        manager.getManagerEmail(email);
    }

    public List<PromotionsEntity> getManagersPromo(int centerId) throws SQLException {
        return manager.getManagerPromotions(centerId);
    }



}
