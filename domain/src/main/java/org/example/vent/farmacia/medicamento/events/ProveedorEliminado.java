package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

public class ProveedorEliminado extends DomainEvent {
    private final ProveedorID proveedorID;

    public ProveedorEliminado(ProveedorID proveedorID) {
        super("org.example.vent.farmacia.ProveedorEliminado");
        this.proveedorID = proveedorID;
    }

    public ProveedorID proveedorID() {
        return proveedorID;
    }
}
