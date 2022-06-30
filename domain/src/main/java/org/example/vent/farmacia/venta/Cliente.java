package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.Entity;

import java.util.Set;

public class Cliente extends Entity<ClienteID> {
    protected Nombre nombre;
    protected Set<FormulaMedica> formulas;

    public Cliente(ClienteID entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public void agregarFormulaMedica(FormulaMedica formulaMedica){
        this.formulas.add(formulaMedica);
    }
}
