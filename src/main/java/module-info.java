module spider.javafxlab1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.scripting;


    opens spider.javafxlab1 to javafx.fxml;
    exports spider.javafxlab1;

    exports spider.javafxlab1.tasktwo;
    opens spider.javafxlab1.tasktwo to javafx.fxml;

    exports spider.javafxlab1.taskthree;
    opens spider.javafxlab1.taskthree to javafx.fxml;

    exports spider.javafxlab1.taskfour;
    opens spider.javafxlab1.taskfour to javafx.fxml;

}