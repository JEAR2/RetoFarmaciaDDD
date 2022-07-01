package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.Nombre;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

public class NombreDeProveedorCambiado extends DomainEvent {
    private final ProveedorID proveedorID;
    private final Nombre nombre;

    public NombreDeProveedorCambiado(ProveedorID proveedorID, Nombre nombre) {
        super("org.example.vent.farmacia.NombreDeProveedorCambiado");
        this.proveedorID = proveedorID;
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }

    public ProveedorID proveedorID() {
        return proveedorID;
    }

}
