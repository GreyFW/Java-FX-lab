package spider.javafxlab1.taskfive;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;


public class TaskFiveController {

    @FXML
    private ToggleGroup topToggleGroup;
    @FXML
    private ToggleGroup middleToggleGroup;
    @FXML
    private ToggleGroup bottomToggleGroup;

    @FXML
    private Button drawButton;
    @FXML
    private TextArea flagTextArea;

    @FXML
    private void drawButtonClick() {
        RadioButton topSelected = (RadioButton) topToggleGroup.getSelectedToggle();
        RadioButton middleSelected = (RadioButton) middleToggleGroup.getSelectedToggle();
        RadioButton bottomSelected = (RadioButton) bottomToggleGroup.getSelectedToggle();

        if (topSelected == null || middleSelected == null || bottomSelected == null) {
            showAlert();
            return;
        }

        String topColor = topSelected.getText();
        String middleColor = middleSelected.getText();
        String bottomColor = bottomSelected.getText();

        String message = "ФЛАГ:\n\n" + topColor + ", " + middleColor + ", " + bottomColor;
        flagTextArea.setText(message);
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText("Цвета выбраны не для всех полос.");
        alert.showAndWait();
    }

}
