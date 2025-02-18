package com.event.eventmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ReportController {

    @FXML
    private Label Venuebill;
    @FXML
    private Label Entertainmentsbill;
    @FXML
    private Label Logisticsbill;
    @FXML
    private Label Totalbill;
    @FXML
    private Label Photographybill;

    @FXML
    private Label hi;

    public int price1, price2, price3, price4, price5;

    @FXML
    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("app.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private Button doneButton;

    @FXML
    protected void handleCloseButtonAction(ActionEvent event) {
        event.consume();
        Stage stage = (Stage) doneButton.getScene().getWindow();
        stage.close();
    }

    public void genarateReport(int venue,int entertainment,int photograpy,int logistics) {
        System.out.println(venue);
        price1 = venue;
        price2 = entertainment;
        price3 = photograpy;
        price4 = logistics;

        //

        /*
        Entertainmentsbill.setText(Integer.toString(entertainment));
        Photographybill.setText(Integer.toString(photograpy));
        Logisticsbill.setText(Integer.toString(logistics));
        int tempbill = venue+entertainment+photograpy+logistics;
        Totalbill.setText(Integer.toString(tempbill));

         */

    }


    public void repot(ActionEvent event) throws IOException {
        price1  = 80750;
        price2  = 65000;
        price3  = 38000;
        price4  = 16000;
        System.out.println(price1);
        Venuebill.setText(Integer.toString(price1));
        Entertainmentsbill.setText(Integer.toString(price2));
        Photographybill.setText(Integer.toString(price3));
        Logisticsbill.setText(Integer.toString(price4));
        int tempbill = price1+price2+price3+price4;
        Totalbill.setText(Integer.toString(tempbill));
    }
}
