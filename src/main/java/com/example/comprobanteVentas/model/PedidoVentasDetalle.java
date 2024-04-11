package com.example.comprobanteVentas.model;

import com.example.comprobanteVentas.exception.CantidadNegativaException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoVentasDetalle extends ComprobanteVentasDetalle {

    public PedidoVentasDetalle(List<Articulo> articulos, int cantidad) throws CantidadNegativaException {
        super(articulos, cantidad);
        if (cantidad < 0) {
            throw new CantidadNegativaException("La cantidad no puede ser negativa");
        }
    }

    public double calcularSubtotal() {
        double total = 0.0;
        for (Articulo articulo : getArticulos()) {
            total += articulo.getPrecio();
        }
        return total * getCantidad();
    }
}
