package spider.javafxlab1.taskthree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TaskThree extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/spider/javafxlab1/TaskThree.fxml"));

        primaryStage.setTitle("Задание 3");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
