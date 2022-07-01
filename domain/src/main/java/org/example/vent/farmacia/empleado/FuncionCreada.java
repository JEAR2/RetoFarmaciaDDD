package org.example.vent.farmacia.empleado;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class FuncionCreada extends DomainEvent {
    private final FuncionID funcionID;
    private final Descripcion descripcion;

    public FuncionCreada(FuncionID funcionID, Descripcion descripcion) {
        super("org.example.vent.farmacia");
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
