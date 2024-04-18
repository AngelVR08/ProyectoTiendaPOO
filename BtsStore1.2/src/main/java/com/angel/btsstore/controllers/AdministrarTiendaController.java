package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdministrarTiendaController {

    @FXML
    private Button salir;
    @FXML
    private Button coleccionables;
    @FXML
    private Button disco;
    @FXML
    private Button elimProductoBtn;

    @FXML
    void onColeccionablesBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"AgregarColeccionable","Agrega un coleccionable...");
    }
    @FXML
    void onDiscoBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"AgregarDisco","Agrega un Disco...");
    }
    @FXML
    void onEliminarBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"EliminarProducto","Elimina un producto...");
    }
    @FXML
    void onSalirBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
    }

}
