package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class FuncionEliminada extends DomainEvent {
    private final FuncionID funcionID;

    public FuncionEliminada(FuncionID funcionID) {
        super("org.example.vent.farmacia.FuncionEliminada");
        this.funcionID = funcionID;
    }

    public FuncionID funcionID() {
        return funcionID;
    }
}
