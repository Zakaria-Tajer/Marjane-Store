package Marj.Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    private static final String DB_NAME = "marjpromo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;


    // method returns a connection to the database
    public static Connection GetConnection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting...");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;



    }

    // method returns a statement object
    public static Statement getStatement() throws SQLException {
        return GetConnection().createStatement();
    }
}
