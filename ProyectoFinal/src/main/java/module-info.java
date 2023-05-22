module com.example.pantallainicial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.inicio.pantallainicial to javafx.fxml;
    exports com.inicio.pantallainicial;
}