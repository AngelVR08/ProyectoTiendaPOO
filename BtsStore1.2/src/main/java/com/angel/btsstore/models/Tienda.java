package com.angel.btsstore.models;

import java.util.ArrayList;

public class Tienda {
    ArrayList <Usuario> usuarios = new ArrayList<>();
    Inventario inventario = new Inventario();

    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void addUser(Usuario usuario){
        usuarios.add(usuario);
    }
}
