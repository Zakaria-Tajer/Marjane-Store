package Marj.Interfaces;

import java.sql.SQLException;

public interface GeneralAdmin {
    void general() throws SQLException;
    void createAdminForStore() throws SQLException;
    void assignAnAdminToAStore() throws SQLException;
}
