package spider.javafxlab1.tasktwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TaskTwoController {

    @FXML
    public VBox hBoxPane;
    @FXML
    private TextField textField;
    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private CheckBox checkBoxTextField;
    @FXML
    private CheckBox checkBoxButton;
    @FXML
    private CheckBox checkBoxLabel;

    public void checkBoxTextField(ActionEvent actionEvent) {
        textField.setVisible(checkBoxTextField.isSelected());
    }
    public void checkBoxButton(ActionEvent actionEvent) {
        button.setVisible(checkBoxButton.isSelected());
    }
    public void checkBoxLabel(ActionEvent actionEvent) {
        label.setVisible(checkBoxLabel.isSelected());
    }

}
