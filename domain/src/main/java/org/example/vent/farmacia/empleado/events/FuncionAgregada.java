package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class FuncionAgregada extends DomainEvent {
    private final FuncionID funcionID;
    private final Descripcion descripcion;

    public FuncionAgregada(FuncionID funcionID, Descripcion descripcion) {
        super("org.example.vent.farmacia.FuncionAgregada");
        this.funcionID = funcionID;
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FuncionID funcionID() {
        return funcionID;
    }
}
