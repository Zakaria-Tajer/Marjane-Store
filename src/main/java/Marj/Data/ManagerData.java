package Marj.Data;

import entity.CentersEntity;
import entity.PromotionsEntity;

import java.util.List;

public class ManagerData {
    private static int managerId;
    private static String email;
    private static String uniqueId;

    public static List<PromotionsEntity> getPromos() {
        return promos;
    }

    public static void setPromos(List<PromotionsEntity> promos) {
        ManagerData.promos = promos;
    }

    private static List<PromotionsEntity> promos;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ManagerData.password = password;
    }

    private static String password;


    public static String getUniqueId() {
        return uniqueId;
    }

    public static void setUniqueId(String uniqueId) {
        ManagerData.uniqueId = uniqueId;
    }


    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        ManagerData.email = email;
    }

    public static int getCityResponsableFor() {
        return cityResponsableFor;
    }

    public static void setCityResponsableFor(int cityResponsableFor) {
        ManagerData.cityResponsableFor = cityResponsableFor;
    }

    private static int cityResponsableFor;
    public static int getManagerId() {
        return managerId;
    }

    public static void setManagerId(int managerId) {
        ManagerData.managerId = managerId;
    }

}



