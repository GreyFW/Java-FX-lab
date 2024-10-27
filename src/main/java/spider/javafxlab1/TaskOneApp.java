package spider.javafxlab1;

import javafx.application.Application;
import javafx.geometry.Pos; // "Position"
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BaseApp extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception {

        Circle circle = new Circle(50);


        Pane pane = new Pane();
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}