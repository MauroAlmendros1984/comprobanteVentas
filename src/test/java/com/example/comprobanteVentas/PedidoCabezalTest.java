package com.example.comprobanteVentas;

import com.example.comprobanteVentas.exception.CantidadNegativaException;
import com.example.comprobanteVentas.exception.PrecioNegativoException;
import com.example.comprobanteVentas.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoCabezalTest {

    @Test
    void crearPedidoVentasCabezal() {
        Date fecha = new Date();
        Cliente cliente = new Cliente("001", "Cliente ejemplo");

        PedidoVentasCabezal pedidoCabezal = new PedidoVentasCabezal(fecha, cliente);

        assertNotNull(pedidoCabezal);
        assertEquals(fecha, pedidoCabezal.getFecha());
        assertNotNull(pedidoCabezal.getNumeroPedido());
        assertEquals(cliente, pedidoCabezal.getCliente());
    }

    @Test
    void calcularTotalPedido() throws PrecioNegativoException {
        Cliente cliente = new Cliente("001", "Cliente ejemplo");
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("001", "Producto 1", 100));
        articulos.add(new Articulo("002", "Producto 2", 50));

        PedidoVentasCabezal pedidoCabezal = new PedidoVentasCabezal(new Date(), cliente);
        try {
            pedidoCabezal.agregarDetalle(new PedidoVentasDetalle(Collections.singletonList(articulos.get(0)), 10));
            pedidoCabezal.agregarDetalle(new PedidoVentasDetalle(Collections.singletonList(articulos.get(1)), 5));

            double totalPedido = pedidoCabezal.calcularTotal();
            assertEquals(1250, totalPedido); // El total esperado es 1250.0 (100 * 10 + 50 * 5)
        } catch (CantidadNegativaException e) {
            fail("Se lanzó una excepción inesperada: " + e.getMessage());
        }
    }
}
