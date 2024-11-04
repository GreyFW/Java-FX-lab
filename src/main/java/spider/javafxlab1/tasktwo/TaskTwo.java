package spider.javafxlab1.tasktwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaskTwo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/spider/javafxlab1/TaskTwo.fxml"));
        primaryStage.setTitle("Задание 2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
