package com.angel.btsstore.controllers;

import com.angel.btsstore.HelloApplication;
import com.angel.btsstore.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InicioSesionController {

    @FXML
    private TextField passUserTxt;

    @FXML
    private Label crearCuentaBtn;

    @FXML
    private Button inicioSesionBTM;

    @FXML
    private TextField nombreUsuExitxt;
    @FXML
    void onInicioSesionBtn(MouseEvent event){

        String name = nombreUsuExitxt.getText();
        String contra = passUserTxt.getText();

        Usuario usuario = new Usuario(name,contra);
        boolean encontro = false;
        for (Usuario i: HelloApplication.getTienda().getUsuarios()){
            if (usuario.getNombre().equals(i.getNombre())){
                System.out.println("User encontrado");
                encontro = true;
                if (usuario.getPass().equals(i.getPass())){
                    HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
                }else{
                    System.out.println("Password incorrecto");
                }
            }
        }
        if (!encontro){
            System.out.println("Usuario no encontrado");
        }
    }
    @FXML
    void crearUserClick(MouseEvent event){
        HelloApplication.nuevaVentana(event,"CrearCuenta","Crea una cuenta");
    }

    @FXML
    void volverBtnClick(MouseEvent event){
        HelloApplication.nuevaVentana(event,"TiendaInicio","Bts Store");
    }
}
