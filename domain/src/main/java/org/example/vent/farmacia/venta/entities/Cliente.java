package org.example.vent.farmacia.venta.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.venta.values.ClienteID;
import org.example.vent.farmacia.venta.values.Nombre;

import java.util.Objects;
import java.util.Set;

public class Cliente extends Entity<ClienteID> {
    protected Nombre nombre;
    protected Set<FormulaMedica> formulas;

    public Cliente(ClienteID entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public void cambiarNombreCliente(Nombre nombre){
        this.nombre = nombre.cambiarNombre(Objects.requireNonNull(nombre));
    }
    public void agregarFormulaMedica(FormulaMedica formulaMedica){
        this.formulas.add(formulaMedica);
    }
}
