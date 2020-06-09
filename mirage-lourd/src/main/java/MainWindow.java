import Controller.FXController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.window.fxml"));
        Parent root = loader.load();
        FXController fxController = loader.getController();
        fxController.setStage(primaryStage);
        primaryStage.setTitle("Mirage");
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.show();
    }
}
