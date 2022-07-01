package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.values.VentaID;

public class VentaEliminada extends DomainEvent {
    private final VentaID ventaID;

    public VentaEliminada(VentaID ventaID) {
        super("org.example.vent.farmacia.VentaEliminada");
        this.ventaID = ventaID;
    }

    public VentaID ventaID() {
        return ventaID;
    }
}
