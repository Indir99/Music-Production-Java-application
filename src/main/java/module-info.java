module com.example.musicproductionv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.musicproductionv2 to javafx.fxml;
    exports com.example.musicproductionv2;
}