module spider.javafxlab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens spider.javafxlab1 to javafx.fxml;
    exports spider.javafxlab1;
}