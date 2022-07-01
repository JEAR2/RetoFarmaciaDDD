package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.Celular;
import org.example.vent.farmacia.medicamento.values.Direccion;
import org.example.vent.farmacia.medicamento.values.Nombre;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

public class ProveedorAgregado extends DomainEvent {

    private final ProveedorID proveedorID;
    private final Direccion direccion;
    private final Celular celular;
    private final Nombre nombre;

    public ProveedorAgregado(ProveedorID proveedorID, Direccion direccion, Celular celular, Nombre nombre) {
        super("org.example.vent.farmacia.ProveedorAgregado");
        this.proveedorID = proveedorID;
        this.direccion = direccion;
        this.celular = celular;
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Celular celular() {
        return celular;
    }

    public Direccion direccion() {
        return direccion;
    }

    public ProveedorID proveedorID() {
        return proveedorID;
    }
}
