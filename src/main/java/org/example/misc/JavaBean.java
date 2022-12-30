package org.example.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaBean {
    private final DatabaseConfig databaseConfig;
    String error;
    Connection con;
    public JavaBean(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseConfig.getName()+"?useSSL=false", databaseConfig.getUser(), databaseConfig.password);
        } catch (Exception cnfe) {
            cnfe.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
