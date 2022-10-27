package Marj.Model;

import Marj.Model.Dao.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model extends DbConnection {
    public ResultSet query(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }
}
