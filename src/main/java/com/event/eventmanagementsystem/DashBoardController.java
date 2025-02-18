package com.event.eventmanagementsystem;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private JFXComboBox<String> eventCategorymenu;

    @FXML
    private JFXComboBox<String> eventmenu;
    ObservableList<String> eventList = FXCollections.observableArrayList("Other");

    @FXML
    private JFXRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    public int budget;

    @FXML
    private TextField capacityTextfild;
    public int capacity;

    @FXML
    private DatePicker datePicker;
    LocalDate date;

    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("app.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    public void nextButtonEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("vanue.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage .setScene(new Scene(root));
        stage.show();
    }

    public void setEventComboBox() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getEventCategory = "Select categoryName from eventcategory  ";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getEventCategory);


            ArrayList<String> eventCategoryList = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("categoryName");
                eventCategoryList.add(eventName);
               // System.out.println(eventName);
            }

            String[] setDatalist = new String[eventCategoryList.size()];
            setDatalist = eventCategoryList.toArray(setDatalist);

            eventCategorymenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void setEventMenu(ActionEvent event) {


        String eventCategory = eventCategorymenu.getValue();
        System.out.println(eventCategory);


        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection dbConnection = dataBaseConnection.getDatabaseLink();

        String getEventCategory = "Select eventname from events where evencategrory = '"+eventCategory+"'" ;

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getEventCategory);


            //ArrayList<String> eventList = new ArrayList<>();

            while (resultSet.next()) {
                String eventName = resultSet.getString("eventname");
                eventList.add(eventName);
                //System.out.println(eventName);
            }

            String[] setDatalist = new String[eventList.size()];
            setDatalist = eventList.toArray(setDatalist);

            eventmenu.getItems().addAll(setDatalist);



        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void getbudget (ActionEvent event) throws IOException {
        if(radioButton1.isSelected()){
            budget=25000;
        }else if(radioButton2.isSelected()){
            budget=100000;
        }else if(radioButton3.isSelected()){
            budget=500000;
        }else if(radioButton4.isSelected()){
            budget=1000000;
        }
        System.out.println(budget);
    }

    public void getAttendence(ActionEvent event){
        try{
            capacity = Integer.parseInt(capacityTextfild.getText());
            System.out.println(capacity);
        }catch (Exception e){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong type");
            alert.setContentText("Plz enter the head count");
            alert.show();
        }
    }

    public void getDate(){
        date = datePicker.getValue();
        System.out.println(date.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEventComboBox();
    }
}
