package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

import static ui.FrontPageController.hospital;


public class HospitalPageController {


    @FXML
    public Label hospitalName;

    @FXML
    public ImageView hospitalImage;

    @FXML
    public TextArea detailsBox;

    @FXML
    public TextArea addressBox;

    @FXML
    public TextArea phoneBox;

    @FXML
    public TextArea waitBox;

    @FXML
    public TextArea ratingBox;

    @FXML
    public TextArea hourBox;

    @FXML
    public Button backButton;

    @FXML
    public Button siteButton;

    @FXML
    public void initialize() {
        hospitalName.setText(hospital.getName());
      //  detailsBox.setText(FrontPageController.hospital.toString());
        addressBox.setText(hospital.getAddress());
        phoneBox.setText(hospital.getPhoneNumber());
        waitBox.setText(hospital.getWaitingTime() + "  minutes");
        ratingBox.setText(String.valueOf(hospital.getRating()));

        String x;
        if(hospital.getHour()){
            x = "Yes";
        } else {
            x = "No";
        }
        hourBox.setText(x);

    }


    public void homeButtonClicked() throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
//        rootPane.getChildren().setAll(pane);
        System.out.println("viewing add new page");
        Parent frontPageWindow;
        frontPageWindow = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Stage mainStage = Main1.parentWindow;
        mainStage.getScene().setRoot(frontPageWindow);
    }

    public void siteButtonClicked() {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(FrontPageController.hospital.getWebsite().toString());
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @FXML
//    public void goBackMainPage() {
//
//    }

}
