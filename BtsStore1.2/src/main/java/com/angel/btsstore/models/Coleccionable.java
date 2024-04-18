package com.angel.btsstore.models;

public class Coleccionable extends Producto{
    private String categoria;

    public Coleccionable(String nombre, double precio, String fechaSalida,String categoria) {
        super(nombre, precio, fechaSalida);
        this.categoria = categoria;
    }

    public String imprimirProduct() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----------Coleccionable----------\n");
        stringBuilder.append("Nombre: ").append(" < ").append(nombre).append(" >\n");
        stringBuilder.append("Precio: ").append(" < $").append(precio).append(" >\n");
        stringBuilder.append("Fecha de salida: ").append(" < ").append(fechaSalida).append(" >\n");
        stringBuilder.append("Categoria: ").append(" < ").append(categoria).append(" >\n");
        return stringBuilder.toString();
    }
}
