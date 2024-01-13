package lk.ijse;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientInitializer {
    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String[] args) {
    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("ClientForm.fxml"))));
        primaryStage.show();
    }
}
