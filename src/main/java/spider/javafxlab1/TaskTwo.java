package spider.javafxlab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaskTwoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\user\\IdeaProjects\\University\\JavaFX-Lab1\\src\\main\\resources"));
        primaryStage.setTitle("Задание 2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
