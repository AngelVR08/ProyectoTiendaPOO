package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Coleccionable;
import com.angel.btsstore.models.Disco;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Collection;

public class ProductosFavController {

    @FXML
    private Button eliminarProbtm;

    @FXML
    private TextField favoritoElitxt;

    @FXML
    private Button salirFavbtm;

    @FXML
    private ListView<String> verFavtxt;
    @FXML
    void initialize(){
        Inventario inventario = HelloApplication.getTienda().getInventario();

        verFavtxt.getItems().clear();

        for (Producto i: inventario.getProductosFav()){
            if (i instanceof Disco){
                verFavtxt.getItems().add(((Disco) i).imprimirProduct());
            } else if (i instanceof Coleccionable) {
                verFavtxt.getItems().add(((Coleccionable) i).imprimirProduct());
            }
        }
    }
    @FXML
    void onSalirBtnClick(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
    }

    @FXML
    void onEliminarBtn(){
        Inventario inventario = HelloApplication.getTienda().getInventario();
        String eliminar = favoritoElitxt.getText();

        boolean eliminado = inventario.elimProductFav(eliminar);

        if (eliminado){
            System.out.println("Se elimino correctamente");
        }else {
            System.out.println("Fallo al eliminar");
        }
    }
}
