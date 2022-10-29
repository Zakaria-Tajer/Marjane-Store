package Marj.Data;

import entity.AdminEntity;

import java.util.List;

public class AdminConst {
    private static String email;
    private static String password;
    private static String uniqueId;
    private static String role;



    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        AdminConst.role = role;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }




}
