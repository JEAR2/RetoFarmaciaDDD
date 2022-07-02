package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.values.*;

public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final RolID rolID;
    private final Descripcion descripcion;

    public EmpleadoCreado(Nombre nombre, Celular celular, Correo correo, RolID rolID, Descripcion descripcion) {
        super("rg.example.vent.farmacia");
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.rolID = rolID;
        this.descripcion = descripcion;
    }

    public Celular celular() {
        return celular;
    }

    public Correo correo() {
        return correo;
    }


    public Nombre nombre() {
        return nombre;
    }

    public RolID rolID() {
        return rolID;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
