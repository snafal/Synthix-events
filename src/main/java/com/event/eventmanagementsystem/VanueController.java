package com.event.eventmanagementsystem;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class VanueController implements Initializable {
    @FXML
    private JFXComboBox<String> venueMenu;

    @FXML
    private JFXComboBox<String> photographyMenu;

    @FXML
    private JFXComboBox<String> entertainmentMenu;
    @FXML
    private JFXComboBox<String> logisticsmenu;

    int venuePrice = 0;
    int logisticsPrice = 0;
    int photographyPrice = 0;
    int entertainmentPrice = 0;

    @FXML
    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("app.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void getReportButton(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("report.fxml")));
        ReportController repo = new ReportController();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        repo.genarateReport(venuePrice, logisticsPrice, photographyPrice, entertainmentPrice);
        stage.show();

    }

    public void setVenueMenu() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getVenue = "SELECT * FROM vanue";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getVenue);


            ArrayList<String> eventCategoryList = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("name");
                eventCategoryList.add(eventName);
                // System.out.println(eventName);
            }

            String[] setDatalist = new String[eventCategoryList.size()];
            setDatalist = eventCategoryList.toArray(setDatalist);

            venueMenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void setEntertainmentMenu() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getVenue = "SELECT * FROM entertainments";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getVenue);


            ArrayList<String> eventCategoryList = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("name");
                eventCategoryList.add(eventName);
                // System.out.println(eventName);
            }

            String[] setDatalist = new String[eventCategoryList.size()];
            setDatalist = eventCategoryList.toArray(setDatalist);

            entertainmentMenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void setPhotographyMenu() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getVenue = "SELECT * FROM photography ";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getVenue);


            ArrayList<String> photographylist = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("name");
                photographylist.add(eventName);
                // System.out.println(eventName);
            }

            String[] setDatalist = new String[photographylist.size()];
            setDatalist = photographylist.toArray(setDatalist);

            photographyMenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void setLogisticsmenu() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getVenue = "SELECT * FROM logistics ";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getVenue);


            ArrayList<String> logisticList = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("name");
                logisticList.add(eventName);
                // System.out.println(eventName);
            }

            String[] setDatalist = new String[logisticList.size()];
            setDatalist = logisticList.toArray(setDatalist);

            logisticsmenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void getvanueprice(ActionEvent event) throws IOException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String tempVenue = venueMenu.getValue();

        String getVenue = "SELECT price FROM vanue WHERE name = '"+tempVenue+"'";

        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getVenue);

            if (resultSet.next()) {
                venuePrice = resultSet.getInt("price");
                System.out.println("Venue Price: " + venuePrice);
            } else {
                System.out.println("Venue not found or price not available.");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }



    }

    public void getEntertaiment(ActionEvent event) throws IOException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String tempEnr = entertainmentMenu.getValue();

        String entertainmentprice = "SELECT price FROM entertainments WHERE name = '"+tempEnr+"'";

        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(entertainmentprice);

            if (resultSet.next()) {
                entertainmentPrice = resultSet.getInt("price");
                System.out.println("Venue Price: " + entertainmentPrice);
            } else {
                System.out.println("Venue not found or price not available.");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }

    }

    public void getLogistics(ActionEvent event) throws IOException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String tempEnr = logisticsmenu.getValue();

        String quar = "SELECT price FROM logistics WHERE name = '"+tempEnr+"'";

        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(quar);

            if (resultSet.next()) {
                logisticsPrice = resultSet.getInt("price");
                System.out.println("Venue Price: " + logisticsPrice);
            } else {
                System.out.println("Venue not found or price not available.");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void getphotography(ActionEvent event) throws IOException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String tempEnr = photographyMenu.getValue();

        String quar = "SELECT price FROM photography WHERE name = '"+tempEnr+"'";

        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(quar);

            if (resultSet.next()) {
                photographyPrice = resultSet.getInt("price");
                System.out.println(tempEnr+" " + photographyPrice);
            } else {
                System.out.println("Venue not found or price not available.");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLogisticsmenu();
        setVenueMenu();
        setPhotographyMenu();
        setEntertainmentMenu();
    }
}
