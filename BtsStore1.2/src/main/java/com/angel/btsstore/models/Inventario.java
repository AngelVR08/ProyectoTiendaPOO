package com.angel.btsstore.models;

import java.util.ArrayList;

public class Inventario {
    ArrayList <Producto> productos = new ArrayList<>();
    ArrayList <Producto> productosFav = new ArrayList<>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Producto> getProductosFav() {
        return productosFav;
    }
    public Boolean elimProducto (String nombre){
        boolean eliminado = false;
        for (int i = 0; i < productos.size(); i++){
            if (nombre.equalsIgnoreCase(productos.get(i).getNombre())){
                productos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    public boolean elimProductFav(String eliminar) {
        boolean eliminado = false;


        for (int i = 0; i < productosFav.size() - 1; i++) {
            if (eliminar.equalsIgnoreCase(productosFav.get(i).getNombre())) {
                productos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }
    public boolean agregarFav(String name){
        for (Producto i:productos){
            if (name.equalsIgnoreCase(i.getNombre())){
                return productosFav.add(i);
            }
        }
        return false;
    }
    public Producto buscarProducto(String nombre){
        Producto producto = null;
        for (Producto i:productos){
            if (nombre.equalsIgnoreCase(i.getNombre())){
                producto = i;
                break;
            }
        }
        return producto;
    }
}
