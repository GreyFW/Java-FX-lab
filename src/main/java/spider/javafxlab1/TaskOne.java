package spider.javafxlab1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TaskOne extends Application {

    private boolean arrowPoint = true;

    @Override
    public void start(Stage primaryStage) {
        TextField leftField = new TextField();
        TextField rightField = new TextField();
        Button button = new Button("→");

        button.setOnAction(event -> {
            if (arrowPoint) {
                rightField.setText(leftField.getText());
                leftField.clear();
                button.setText("←");
            } else {
                leftField.setText(rightField.getText());
                rightField.clear();
                button.setText("→");
            }
            arrowPoint = !arrowPoint;
        });

        Pane pane = new Pane();
        leftField.setLayoutX(40);
        leftField.setLayoutY(125);
        pane.getChildren().add(leftField);

        rightField.setLayoutX(311);
        rightField.setLayoutY(125);
        pane.getChildren().add(rightField);

        button.setLayoutX(240);
        button.setLayoutY(170);
        pane.getChildren().add(button);

        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Задание 1");

        primaryStage.show();

    }
}