module org.unicrondk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.unicorndk to javafx.fxml;
    exports org.unicorndk;
}