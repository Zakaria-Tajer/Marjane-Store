package Marj.Data;

import entity.CentersEntity;
import entity.PromotionsEntity;

import java.time.LocalDate;
import java.util.List;

public class ManagerData {
    private static int managerId;
    private static String email;
    private static String uniqueId;
    private static String password;
    private static String CentersByCityResponsableFor;
    private static int promotionId;
    private static int reduction;

    public static int getPromotionId() {
        return promotionId;
    }

    public static void setPromotionId(int promotionId) {
        ManagerData.promotionId = promotionId;
    }

    public static int getReduction() {
        return reduction;
    }

    public static void setReduction(int reduction) {
        ManagerData.reduction = reduction;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        ManagerData.stock = stock;
    }

    public static LocalDate getExpiringDate() {
        return expiringDate;
    }

    public static void setExpiringDate(LocalDate expiringDate) {
        ManagerData.expiringDate = expiringDate;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        ManagerData.status = status;
    }

    private static int stock;
    private static LocalDate expiringDate;
    private static String status;

    public static String getCategoryByCategoryRespoFor() {
        return CategoryByCategoryRespoFor;
    }

    public static void setCategoryByCategoryRespoFor(String categoryByCategoryRespoFor) {
        CategoryByCategoryRespoFor = categoryByCategoryRespoFor;
    }

    private static String CategoryByCategoryRespoFor;

    public static String getCentersByCityResponsableFor() {
        return CentersByCityResponsableFor;
    }

    public static void setCentersByCityResponsableFor(String centersByCityResponsableFor) {
        CentersByCityResponsableFor = centersByCityResponsableFor;
    }


    private static int cityResponsableFor;
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

    public static int getManagerId() {
        return managerId;
    }

    public static void setManagerId(int managerId) {
        ManagerData.managerId = managerId;
    }

}



