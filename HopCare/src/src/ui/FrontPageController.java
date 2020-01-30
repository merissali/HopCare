package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Hospital;

import java.io.IOException;


public class FrontPageController {

    public static Hospital hospital;


    @FXML
    public TableView<Hospital> tableView;

    @FXML
    public TableColumn<Hospital, String> hospitalName;

    @FXML
    public TableColumn<Hospital, String> address;

    @FXML
    public TableColumn<Hospital, String> phoneNumber;

    @FXML
    public TableColumn<Hospital, Integer> waitTime;

    @FXML
    public void initialize() {
        hospitalName.setCellValueFactory(new PropertyValueFactory<Hospital, String>("name"));
        address.setCellValueFactory(new PropertyValueFactory<Hospital, String>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Hospital, String>("phoneNumber"));
        waitTime.setCellValueFactory(new PropertyValueFactory<Hospital, Integer>("waitingTime"));

        tableView.setItems(getHospitals());
    }

    @FXML
    public void openHospital() throws IOException {
        hospital = tableView.getSelectionModel().getSelectedItem();
        viewHospitalPage();
        System.out.println(hospital.getName());
        System.out.println("It worked!");
    }

    @FXML
    public ObservableList<Hospital> getHospitals() {
        ObservableList<Hospital> hospitals = FXCollections.observableArrayList();
        for (Hospital h: HospitalAPI.hospitals) {
            hospitals.add(h);
        }

        return hospitals;
    }

    @FXML
    public void viewHospitalPage() throws IOException {
//        System.out.println("viewing add new page");
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("HospitalPage.fxml"));
//        rootPane.getChildren().setAll(pane);
        System.out.println("viewing add new page");
        Parent hospitalPageWindow;
        hospitalPageWindow = FXMLLoader.load(getClass().getResource("HospitalPage.fxml"));
        Stage mainStage = Main1.parentWindow;
        mainStage.getScene().setRoot(hospitalPageWindow);
    }
}
