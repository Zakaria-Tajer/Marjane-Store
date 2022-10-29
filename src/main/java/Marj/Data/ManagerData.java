package Marj.Data;

public class ManagerData {
    private static int managerId;

    public static int getManagerId() {
        return managerId;
    }

    public static void setManagerId(int managerId) {
        ManagerData.managerId = managerId;
    }

}
