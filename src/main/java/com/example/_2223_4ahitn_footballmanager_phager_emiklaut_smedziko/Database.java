package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String host = "localhost";
    private String user = "football";
    private String db = "football";
    private String password = "football";
    private String driverType = "mysql";
    private int port = 4306;
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Database() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:" + driverType + "://" + host + ":" + port + "/" + db + "?useSSL=false",
                    user,
                    password
            );

            connection = c;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        if (connection == null) {
            new Database();
        }

        return connection;
    }

}