package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.values.VentaID;

public class VentaAgregada extends DomainEvent {
    private final VentaID ventaID;

    public VentaAgregada(VentaID ventaID) {
        super("org.example.vent.farmacia.VentaAgregada");
        this.ventaID = ventaID;
    }

    public VentaID ventaID() {
        return ventaID;
    }
}
