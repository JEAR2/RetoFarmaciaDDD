package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.Celular;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

public class CelularDeProveedorCambiado extends DomainEvent {
    private final ProveedorID proveedorID;
    private final Celular celular;

    public CelularDeProveedorCambiado(ProveedorID proveedorID, Celular celular) {
        super("org.example.vent.farmacia.CelularDeProveedorCambiado");
        this.proveedorID = proveedorID;
        this.celular = celular;
    }

    public Celular celular() {
        return celular;
    }

    public ProveedorID proveedorID() {
        return proveedorID;
    }
}
