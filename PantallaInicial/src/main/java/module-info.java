module com.inicio.pantallainicial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.inicio.pantallainicial to javafx.fxml;
    exports com.inicio.pantallainicial;
}