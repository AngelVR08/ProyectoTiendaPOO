package com.angel.btsstore.models;

import java.util.Objects;

public class Producto {
    protected String nombre;
    protected double precio;
    protected String fechaSalida;

    public Producto(String nombre, double precio, String fechaSalida) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaSalida = fechaSalida;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
