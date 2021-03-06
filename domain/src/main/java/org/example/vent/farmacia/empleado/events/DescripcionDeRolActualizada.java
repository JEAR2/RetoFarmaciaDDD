package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.RolID;

public class DescripcionDeRolActualizada extends DomainEvent {
    private final RolID rolID;
    private final String descripcion;

    public DescripcionDeRolActualizada(RolID rolID, String descripcion) {
        super("org.example.vent.farmacia.DescripcionDeRolActualizada");
        this.rolID = rolID;
        this.descripcion = descripcion;
    }

    public String descripcion() {
        return descripcion;
    }

    public RolID rolID() {
        return rolID;
    }
}
