package com.event.eventmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;


public class AppController {

    @FXML
    private Button closeButton;

    @FXML
    public TextField userName = null;

    @FXML
    public PasswordField password = null;

    @FXML
    public Label errorMessagelable;


    @FXML
    protected void handleCloseButtonAction(ActionEvent event) {
        event.consume();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void loginbuttonAction(ActionEvent event) throws IOException {

        if(userName.getText().isBlank() || password.getText().isBlank()){
            errorMessagelable.setText("Please enter Username and Password");
        }else{
            validateUser();
            errorMessagelable.setText("Welcome to the Event Management System!");
            if(Objects.equals(errorMessagelable.getText(), "Welcome to the Event Management System!")){
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashBoard.fxml")));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root ,800, 600);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    public void signupbuttonAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUp.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public void validateUser(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getDatabaseLink();

        String verifyLogin="SELECT count(1) FROM user where userName = '"+userName.getText()+"' and password ='"+password.getText()+"'";
        try {
            Statement stmt = connectDB.createStatement();
            ResultSet rs = stmt.executeQuery(verifyLogin);

            while(rs.next()){
                if(rs.getInt(1)==1){
                    errorMessagelable.setText("Welcome to the Event Management System!");
                }else {
                    errorMessagelable.setText("Login Failed");
                }
            }
        }catch (Exception e){
           // e.printStackTrace();
        }
    }
}
