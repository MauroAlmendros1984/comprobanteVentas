package com.example.comprobanteVentas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoVentasCabezal extends ComprobanteVentasCabezal implements CalcularTotal {
    private List<PedidoVentasDetalle> detalles;

    public PedidoVentasCabezal(Date fecha, Cliente cliente) {
        super(fecha, cliente);
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(PedidoVentasDetalle detalle) {
        this.detalles.add(detalle);
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (PedidoVentasDetalle detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }
}
