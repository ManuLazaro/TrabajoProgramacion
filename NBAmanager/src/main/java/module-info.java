module com.example.nbamanager {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
    requires java.sql;


    opens com.example.nbamanager to javafx.fxml;
    exports com.example.nbamanager;
}