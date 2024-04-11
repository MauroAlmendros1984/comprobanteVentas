package com.example.comprobanteVentas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String codigoCliente;
    private String descripcionCliente;

    public Cliente(String codigoCliente, String descripcionCliente) {
        this.codigoCliente = codigoCliente;
        this.descripcionCliente = descripcionCliente;
    }
}
