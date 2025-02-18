package com.event.eventmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnection {
    public  Connection databaseLink;

    public Connection getDatabaseLink() {
        String databaseName = "synthixevents";
        String databaseURL = "jdbc:mysql://localhost:3306/" + databaseName;
        String databaseUser = "root";
        String databasePassword = "Lahiru@2000";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
        }catch (Exception e){
            System.out.println(e);
        }
        return databaseLink;
    }

}
