package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class DescripcionDeFuncionActualizada extends DomainEvent {
    private final FuncionID funcionID;
    private final Descripcion descripcion;

    public DescripcionDeFuncionActualizada(FuncionID funcionID, Descripcion descripcion) {
        super("org.example.vent.farmacia.DescripcionDeFuncionActualizada");
        this.funcionID = funcionID;
        this.descripcion = descripcion;
    }

    public FuncionID funcionID() {
        return funcionID;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
