/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class JConnection {
    private String url;
    private String user;
    private String pass;    
    private Connection con;
    
    public JConnection(){
        url = "jdbc:mysql://localhost:3306/library";
        user = "root";
        pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {  
            con = null;
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }


    public String getPass() {
        return pass;
    }

    public Connection getConnection() {
        return con;
    }
}
