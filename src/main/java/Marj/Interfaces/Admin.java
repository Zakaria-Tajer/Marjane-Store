package Marj.Interfaces;

import java.sql.SQLException;

public interface Admin {
    void general() throws SQLException;
    void createDepartmentManager();
}
