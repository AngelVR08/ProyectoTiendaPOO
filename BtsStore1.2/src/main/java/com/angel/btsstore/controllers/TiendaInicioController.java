package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class TiendaInicioController {
    @FXML
    private Label masInfoBtn;
    @FXML
    private Button administracionBtn;

    @FXML
    private Button agregarBtn;

    @FXML
    private TextField agregarFavTxt;
    @FXML
    private TextField buscarProductTxt;

    @FXML
    private Button iniciarSBtn;

    @FXML
    private ListView<String> listaProductos;

    @FXML
    private Button salirBtn;

    @FXML
    private Button verFavBtn;

    @FXML
    void imagenClick (MouseEvent event){
     HelloApplication.nuevaVentana(event,"TiendaProducto","produto");
    }
    @FXML
    void salirProducto (MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicio","inicio");
    }

    @FXML
    void initialize() {
        Tienda tienda = HelloApplication.getTienda();
        Inventario inventario = tienda.getInventario();

        listaProductos.getItems().clear();
        for (Producto i:inventario.getProductos()){
            if (i instanceof Disco){
                listaProductos.getItems().add(((Disco) i).imprimirProduct());
            } else if (i instanceof Coleccionable) {
                listaProductos.getItems().add(((Coleccionable) i).imprimirProduct());
            }
        }
    }
    @FXML
    void onIniciarSBtnClick(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicioSesion","Iniciar sesion...");
    }
    @FXML
    void onVerFavClick(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaFavoritos", "Favoritos...");
    }
    @FXML
    void onAdministracionCLick(MouseEvent event){
        Tienda tienda = HelloApplication.getTienda();
        ArrayList<Usuario> usuarios = tienda.getUsuarios();

        if (!usuarios.isEmpty()){
            HelloApplication.nuevaVentana(event,"AdministrarTienda","Administra la tienda...");
        }else {
            HelloApplication.showAlert(Alert.AlertType.ERROR,"Error","Inicia sesion primero.");
        }
    }
    @FXML
    void onAgregarFavClick(){
        Tienda tienda = HelloApplication.getTienda();
        Inventario inventario = tienda.getInventario();

        String fav = agregarFavTxt.getText();
        boolean agrego = inventario.agregarFav(fav);
        if (agrego){
            System.out.println("Agregado");
        }else{
            System.out.println("No agregado");
        }
    }
    @FXML
    void btnNavegador() {
        String url = "https://www.facebook.com/BTSshopMex?mibextid=ZbWKwL";
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            e.printStackTrace();
            HelloApplication.showAlert(Alert.AlertType.ERROR,"Error","No se pudo abrir el navegador");
        }
    }
    @FXML
    void buscarClick(){
        Inventario inventario = HelloApplication.getTienda().getInventario();

        String objetivo = buscarProductTxt.getText();
        Producto producto = inventario.buscarProducto(objetivo);
        if (producto == null){
            HelloApplication.showAlert(Alert.AlertType.ERROR,"Error","No se encontro el producto");
        }else{
            listaProductos.getItems().clear();
            listaProductos.getItems().add("------------------------------------");
            listaProductos.getItems().add("         Producto buscado:");
            if (producto instanceof Disco){
                listaProductos.getItems().add(((Disco) producto).imprimirProduct());
            } else if (producto instanceof Coleccionable) {
                listaProductos.getItems().add(((Coleccionable) producto).imprimirProduct());
            }
        }
    }
}
