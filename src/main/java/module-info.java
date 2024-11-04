module spider.javafxlab1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens spider.javafxlab1 to javafx.fxml;
    exports spider.javafxlab1;
    exports spider.javafxlab1.taskthree;
    opens spider.javafxlab1.taskthree to javafx.fxml;
}