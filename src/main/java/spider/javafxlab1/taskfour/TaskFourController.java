package spider.javafxlab1.taskfour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TaskFourController {

    @FXML
    private Label displayLabel;

    private double currentValue = 0.0; // по умолчанию = 0
    private String currentOperation = ""; // строка для приёма операции нажатой юзером
    private boolean startNewValue = true; // устанавливаем ввод нового значения по умолчанию

    @FXML
    private void onButtonClick(ActionEvent event) {
        // данное действие привязали к каждой кнопке. т.к. по факту наши кнопки легко различить по их тексту,
        // то его и просматриваем и исходя из этого реагируем

        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                mathOperation(buttonText);
                break;
            case "=":
                calculateResult();
                break;
            case "C":
                clearDisplay();
                break;
            default:
                digitInput(buttonText);
        }
    }

    // реагируем на нажатую цифру
    private void digitInput(String digit) {
        if (startNewValue) { // if (мы начинаем считать, а не продолжаем)
            displayLabel.setText(digit); // выводим введённые юзером числа на экран
            startNewValue = false; // цифры введены, больше не вводим новое значение, переводим флаг в false
        } else { // else (мы продолжали считать, а не начинали)
            displayLabel.setText(displayLabel.getText() + digit); // берём то, что уже ввели и добавляем к нему введённое сейчас
        }
    }

    private void mathOperation(String operation) {
        currentOperation = operation; // текущая операция = полученный текст с кнопки
        currentValue = Double.parseDouble(displayLabel.getText());
        // parseDouble - метод класса Double, принимает строку как аргумент и пытается ковентировать её в raw-type double
        startNewValue = true; // после того, как мы обработали мат. операцию,
        // мы снова можем принимать и печатать на экране новые числа
    }

    private void calculateResult() {
        double secondValue = Double.parseDouble(displayLabel.getText());
        double result = 0.0;

        switch (currentOperation) {
            case "+" -> result = currentValue + secondValue;
            case "-" -> result = currentValue - secondValue;
            case "*" -> result = currentValue * secondValue;
            case "/" -> {
                if (secondValue == 0) {
                    zeroDivError();
                    return;
                }
                result = currentValue / secondValue;
            }
        }

        displayLabel.setText(String.valueOf(result));
        currentValue = result;

        startNewValue = true;
        currentOperation = "";
    }

    private void clearDisplay() {
        displayLabel.setText("0");
        currentValue = 0;
        currentOperation = "";
        startNewValue = true;
    }

    private void zeroDivError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText("Ошибка: деление на 0");
        alert.showAndWait();
    }
}