package com.example.comprobanteVentas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public abstract class ComprobanteVentasCabezal implements CalcularTotal {
    private Date fecha;
    private String numeroPedido;
    private Cliente cliente;
    public ComprobanteVentasCabezal(Date fecha, Cliente cliente) {
        this.fecha = fecha;
        this.numeroPedido = generarNumeroPedido();
        this.cliente = cliente;
    }

    private String generarNumeroPedido() {
        // Implementación para generar el número de pedido
        return "PED-" + UUID.randomUUID(); // Ejemplo simple de generación de número de pedido
    }

}
