module org.example.proyectotienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectotienda to javafx.fxml;
    exports org.example.proyectotienda;
    exports org.example.proyectotienda.controllers;
    opens org.example.proyectotienda.controllers to javafx.fxml;
}