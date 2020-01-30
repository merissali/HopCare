package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static Stage parentWindow;
    //TableView<Hospital> tableView = new TableView<Hospital>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        parentWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        primaryStage.setTitle("HOPCARE");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }



    public static void main(String[] args) {
        HospitalAPI hospitalAPI = new HospitalAPI();
        hospitalAPI.testAPI();
        launch(args);
    }
}
