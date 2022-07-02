package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.entities.Cliente;
import org.example.vent.farmacia.venta.values.ClienteID;
import org.example.vent.farmacia.venta.values.Nombre;
import org.example.vent.farmacia.venta.values.VentaID;

public class VentaCreada extends DomainEvent {
    private final VentaID ventaID;
    private final ClienteID clienteID;
    private final Nombre nombre;

    public VentaCreada(VentaID ventaID, ClienteID clienteID, Nombre nombre) {
        super("org.example.vent.farmacia.VentaCreada");
        this.ventaID = ventaID;
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public VentaID ventaID() {
        return ventaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
