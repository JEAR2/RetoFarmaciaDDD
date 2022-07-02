package org.example.vent.farmacia.empleado;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.Celular;
import org.example.vent.farmacia.empleado.values.EmpleadoID;

public class CelularEmpleadoCambiado extends DomainEvent {
    private final EmpleadoID empleadoID;
    private final Celular celular;

    public CelularEmpleadoCambiado(EmpleadoID empleadoID, Celular celular) {
        super("org.example.vent.farmacia.CelularEmpleadoCambiado");
        this.empleadoID = empleadoID;
        this.celular = celular;
    }

    public EmpleadoID empleadoID() {
        return empleadoID;
    }

    public Celular celular() {
        return celular;
    }
}
