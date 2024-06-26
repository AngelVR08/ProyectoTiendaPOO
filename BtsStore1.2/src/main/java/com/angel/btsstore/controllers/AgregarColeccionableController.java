package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Coleccionable;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarColeccionableController {

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField categoriaTxt;

    @FXML
    private ListView<String> inventarioColetxt;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField precioTxt;

    @FXML
    private TextField salidaTxt;

    @FXML
    private Button salirbtm;
    @FXML
    void initialize(){
        Inventario inventario = HelloApplication.getTienda().getInventario();
        inventarioColetxt.getItems().clear();
        for (Producto i: inventario.getProductos()){
            if (i instanceof Coleccionable){
                inventarioColetxt.getItems().add(((Coleccionable) i).imprimirProduct());
            }
        }
    }

    @FXML
    void onSalirBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"AdministrarTienda","Bts Store");
    }
    @FXML
    void onAgregarBtn(){
        Inventario inventario = HelloApplication.getTienda().getInventario();;
        String nombre = nombreTxt.getText();
        double precio = Double.parseDouble(precioTxt.getText());
        String categoria = categoriaTxt.getText();
        String fSalida = salidaTxt.getText();

        Coleccionable producto = new Coleccionable(nombre,precio,fSalida,categoria);
        boolean agregado = inventario.agregarProducto(producto);

        if (agregado){
            inventarioColetxt.getItems().add(producto.imprimirProduct());
            System.out.println("Coleccionable Agregado");
        }else{
            System.out.println("Coleccionable no agregado");
        }
    }

}
