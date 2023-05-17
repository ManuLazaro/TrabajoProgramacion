module com.menu.menuprincipal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.menu.menuprincipal to javafx.fxml;
    exports com.menu.menuprincipal;
}