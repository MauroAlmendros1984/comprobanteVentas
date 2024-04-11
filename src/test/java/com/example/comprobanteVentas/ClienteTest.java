package com.example.comprobanteVentas;

import com.example.comprobanteVentas.model.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    void crearCliente() {
        String codigo = "001";
        String descripcion = "Cliente ejemplo";

        Cliente cliente = new Cliente(codigo, descripcion);

        assertEquals(codigo, cliente.getCodigoCliente());
        assertEquals(descripcion, cliente.getDescripcionCliente());
    }
}
