package com.example.comprobanteVentas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class ComprobanteVentasDetalle  {
    private List<Articulo> articulos;
    private int cantidad;
    public ComprobanteVentasDetalle(List<Articulo> articulos, int cantidad) {
        this.articulos = articulos;
        this.cantidad = cantidad;
    }
}
