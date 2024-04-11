package com.example.comprobanteVentas;

import com.example.comprobanteVentas.exception.CantidadNegativaException;
import com.example.comprobanteVentas.exception.PrecioNegativoException;
import com.example.comprobanteVentas.model.Articulo;
import com.example.comprobanteVentas.model.PedidoVentasDetalle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PedidoDetalleTest {

    @Test
    void calcularSubtotal() throws PrecioNegativoException {
        Articulo articulo = new Articulo("001", "Producto 1", 100);

        try {
            PedidoVentasDetalle pedidoDetalle = new PedidoVentasDetalle(Collections.singletonList(articulo), 10);
            double subtotal = pedidoDetalle.calcularSubtotal();
            assertEquals(1000, subtotal); // El subtotal esperado es 1000.0 (100 * 10)
        } catch (CantidadNegativaException e) {
            fail("Se lanzó una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    void crearPedidoVentasDetalle_CantidadNegativa_DeberiaLanzarExcepcion() throws PrecioNegativoException {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("001", "Producto 1", 100));

        assertThrows(CantidadNegativaException.class, () -> {
            new PedidoVentasDetalle(articulos, -5);
        });
    }
}