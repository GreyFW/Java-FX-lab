package spider.javafxlab1.taskthree;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;


public class TaskThreeController {

    @FXML
    private ListView<String> dishesListView;
    @FXML
    private TextField dishTextField;
    @FXML
    private Spinner<Integer> servingsSpinner;
    @FXML
    private Button dishAddButton;
    @FXML
    private TextArea chequeTextArea;
    @FXML
    private Button toOrderButton;

    private List<Dish> menu = new ArrayList<>();
    private List<Dish> selectedDishes = new ArrayList<>();
    private Dish selectedDish;

    @FXML
    private void initialize() {

        menu.add(new Dish("Чай", 50.00));
        menu.add(new Dish("Кофе", 69.99));
        menu.add(new Dish("Салат Цезарь", 399.50));
        menu.add(new Dish("Хачапури по-аджарски", 350.30));
        menu.add(new Dish("Борщ", 100.00));
        menu.add(new Dish("Лосось", 400.50));
        menu.add(new Dish("Курица гриль", 350.99));
        menu.add(new Dish("Паста", 150.00));
        menu.add(new Dish("Жаркое", 349.99));
        menu.add(new Dish("Отварной картофель", 149.99));

        // устанавливаем количество "порций" от 1 до 10
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        servingsSpinner.setValueFactory(valueFactory);

        for (Dish dish : menu) {
            dishesListView.getItems().add(dish.getName());
        }

        // реализуем выбор блюда в меню (объект ListView)
        dishesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedDish(newValue);
            }
        });

        // добавляем реакции кнопок на нажатие, ф-ции реализованы в конце кода
        dishAddButton.setOnAction(event -> addDishToOrder());
        toOrderButton.setOnAction(event ->  orderConfirmed());
    }

    private void selectedDish(String dishName) {
        dishTextField.setText(dishName);

        for (Dish dish : menu) {
            if (dish.getName().equals(dishName)) {
                selectedDish = new Dish(dish.getName(), dish.getCost(), servingsSpinner.getValue());
                break;
            }
        }
    }

    private void addDishToOrder() {
        if (selectedDish == null) {
            showAlert();
            return;
        }

        // добавляем выбранному блюду указанное юзером кол-во порций на "спиннере"
        selectedDish.setServings(servingsSpinner.getValue());
        selectedDishes.add(selectedDish);
        updateCheque();
    }

    private void updateCheque() {
        StringBuilder chequeText = new StringBuilder();
        double totalOrderCost = 0.0;

        for (Dish dish : selectedDishes) {
            chequeText.append(dish.getName()).append("\tx")
                      .append(dish.getServings()).append("\t")
                      .append(String.format("%.2f", dish.getTotalCost())).append("\n");

            totalOrderCost += dish.getTotalCost();
        }

        chequeText.append("\n\nСумма заказа:\t     ").append(String.format("%.2f", totalOrderCost)).append(" руб.");
        chequeTextArea.setText(chequeText.toString());
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText("Вы не выбрали блюдо.");
        alert.showAndWait();
    }

    private void orderConfirmed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Заказ оформлен");
        alert.setHeaderText(null);
        alert.setContentText("Ваш заказ успешно оформлен!\n\tОжидайте готовности.");
        alert.showAndWait();
    }

}