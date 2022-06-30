package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.values.Celular;
import org.example.vent.farmacia.empleado.values.Correo;
import org.example.vent.farmacia.empleado.values.Nombre;

public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final Rol rol;

    public EmpleadoCreado(Nombre nombre, Celular celular, Correo correo, Rol rol) {
        super("rg.example.vent.farmacia");
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.rol = rol;
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

    public Rol rol() {
        return rol;
    }
}
