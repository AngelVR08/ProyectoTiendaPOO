package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Inventario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EliminarProductoController {

    @FXML
    private Button eliminarProbtm;

    @FXML
    private TextField nombreProElitxt;

    @FXML
    private Button salirProbtm;

    @FXML
    void onElimBtnClick(){
        Inventario inventario = HelloApplication.getTienda().getInventario();
        String eliminarProducto = nombreProElitxt.getText();

        boolean exito = inventario.elimProducto(eliminarProducto);
        if (exito){
            System.out.println("Eliminado");
        }else {
            System.out.println("fallo al eliminar");
        }

    }
    @FXML
    void onSalirBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
    }
}
