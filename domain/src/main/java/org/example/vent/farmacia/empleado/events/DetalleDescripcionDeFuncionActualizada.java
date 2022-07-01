package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class DetalleDescripcionDeFuncionActualizada extends DomainEvent {
    private final FuncionID funcionID;
    private final String descripcion;

    public DetalleDescripcionDeFuncionActualizada(FuncionID funcionID, String descripcion) {
        super("org.example.vent.farmacia.DescripcionDeFuncionActualizada");
        this.funcionID = funcionID;
        this.descripcion = descripcion;
    }

    public FuncionID funcionID() {
        return funcionID;
    }

    public String descripcion() {
        return descripcion;
    }
}
