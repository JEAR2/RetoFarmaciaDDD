package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.entities.Cliente;
import org.example.vent.farmacia.venta.values.VentaID;

public class VentaCreada extends DomainEvent {
    private final VentaID ventaID;
    private final Cliente cliente;

    public VentaCreada(VentaID ventaID, Cliente cliente) {
        super("org.example.vent.farmacia.VentaCreada");
        this.ventaID = ventaID;
        this.cliente = cliente;
    }

    public VentaID ventaID() {
        return ventaID;
    }

    public Cliente cliente() {
        return cliente;
    }
}
