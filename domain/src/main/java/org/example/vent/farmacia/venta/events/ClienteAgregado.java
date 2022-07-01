package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.entities.Cliente;

public class ClienteAgregado extends DomainEvent {
    private final Cliente cliente;

    public ClienteAgregado(Cliente cliente) {
        super("org.example.vent.farmacia.ClienteAgregado");
        this.cliente = cliente;
    }

    public Cliente cliente() {
        return cliente;
    }
}
