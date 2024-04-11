package com.example.comprobanteVentas.model;

import com.example.comprobanteVentas.exception.PrecioNegativoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Articulo {
    private String codigoArticulo;
    private String descripcionArticulo;
    private double precio;
    public Articulo(String codigoArticulo, String descripcionArticulo, double precio)  throws PrecioNegativoException {
        this.codigoArticulo = codigoArticulo;
        this.descripcionArticulo = descripcionArticulo;
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }
}
