package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Disco;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarDiscoController{

    @FXML
    private Button agregarDisbtm;

    @FXML
    private TextField albumTxt;

    @FXML
    private TextField fSalidaTxt;

    @FXML
    private ListView<String> inventarioDistxt;

    @FXML
    private TextField nombreDistxt;

    @FXML
    private TextField precioDistxt;

    @FXML
    private Button salirDisbtm;
    @FXML
    void initialize(){
        Inventario inventario = HelloApplication.getTienda().getInventario();

        inventarioDistxt.getItems().clear();
        for (Producto i: inventario.getProductos()){
         if (i instanceof Disco){
             inventarioDistxt.getItems().add(((Disco) i).imprimirProduct());
         }
        }

    }
    @FXML
    void onAgregarBtn(){
        Inventario inventario = HelloApplication.getTienda().getInventario();

        String nombre = nombreDistxt.getText();
        double precio = Double.parseDouble(precioDistxt.getText());
        String fSalida = fSalidaTxt.getText();
        String album = albumTxt.getText();

        Disco disco = new Disco(nombre,precio,fSalida,album);
        boolean agregado = inventario.agregarProducto(disco);
        if (agregado){
            inventarioDistxt.getItems().add(disco.imprimirProduct());
            System.out.println("Disco Agregado");

        }else{
            System.out.println("Disco no agregado");
        }
    }
    @FXML
    void onSalirBtn(MouseEvent event){
        HelloApplication.nuevaVentana(event,"AdministrarTienda","Bts Store");
    }

}