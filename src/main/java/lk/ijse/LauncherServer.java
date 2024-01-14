package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherServer extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(getClass().getResource("view/ServerForm.fxml"));

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Login Form");
        stage.setResizable(false);
        stage.show();
    }
}
