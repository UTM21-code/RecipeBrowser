module com.example.foodproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.foodproject to javafx.fxml;
    exports com.example.foodproject;
}