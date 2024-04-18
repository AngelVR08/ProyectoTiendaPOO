package com.angel.btsstore.models;

public class Disco extends Producto{
    private String album;

    public Disco(String nombre, double precio, String fechaSalida,String album) {
        super(nombre, precio, fechaSalida);
        this.album = album;
    }

    public String imprimirProduct() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----------Disco----------\n");
        stringBuilder.append("Nombre: ").append(" < ").append(nombre).append(" >\n");
        stringBuilder.append("Precio: ").append(" < $").append(precio).append(" >\n");
        stringBuilder.append("Fecha de salida: ").append(" < ").append(fechaSalida).append(" >\n");
        stringBuilder.append("Album: ").append(" < ").append(album).append(" >\n");

        return stringBuilder.toString();
    }
}
