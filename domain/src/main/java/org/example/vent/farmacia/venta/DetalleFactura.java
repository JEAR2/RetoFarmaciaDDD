package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.ValueObject;

public class DetalleFactura implements ValueObject<String> {
    private final String value;

    public DetalleFactura(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public DetalleFactura cambiarDetalleFactura(String detalleFacturaModificada){
        return new DetalleFactura(detalleFacturaModificada);
    }
}
