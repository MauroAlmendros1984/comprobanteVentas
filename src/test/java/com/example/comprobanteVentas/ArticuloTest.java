package com.example.comprobanteVentas;

import com.example.comprobanteVentas.exception.PrecioNegativoException;
import com.example.comprobanteVentas.model.Articulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArticuloTest {

    @Test
    void crearArticulo() throws PrecioNegativoException {
        String codigo = "001";
        String descripcion = "Producto 1";
        double precio = 100;

        Articulo articulo = new Articulo(codigo, descripcion, precio);
        assertEquals(codigo, articulo.getCodigoArticulo());
        assertEquals(descripcion, articulo.getDescripcionArticulo());
        }

    @Test
    void crearArticulo_ConPrecioNegativo() {
        String codigoArticulo = "001";
        String descripcionArticulo = "Producto 1";
        double precioNegativo = -50.0;

        assertThrows(PrecioNegativoException.class, () -> {
            new Articulo(codigoArticulo, descripcionArticulo, precioNegativo);
        });
    }
}
