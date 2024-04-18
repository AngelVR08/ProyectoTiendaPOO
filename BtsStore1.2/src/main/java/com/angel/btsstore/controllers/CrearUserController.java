package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Inventario;
import com.angel.btsstore.models.Tienda;
import com.angel.btsstore.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrearUserController {

    @FXML
    private TextField passUserTxt;

    @FXML
    private Button crearCuenbtm;

    @FXML
    private TextField nombreUsutxt;

    @FXML
    private TextField repContraTxt;

    @FXML
    void crearUserClick(MouseEvent event) {
        Tienda tienda = HelloApplication.getTienda();
        String nombre = nombreUsutxt.getText();
        String pass = passUserTxt.getText();
        String passAux = repContraTxt.getText();

        if (pass.equals(passAux)){
            Usuario usuario = new Usuario(nombre,pass);
            tienda.addUser(usuario);
            HelloApplication.showAlert(Alert.AlertType.INFORMATION,"Usuario","El usuario se creo con exito");
            HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
        }else {
            HelloApplication.showAlert(Alert.AlertType.ERROR,"Usuario", "Las claves no coinciden");
        }
    }

}
