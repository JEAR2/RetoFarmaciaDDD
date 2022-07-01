package org.example.vent.farmacia.medicamento.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.medicamento.values.LaboratorioID;
import org.example.vent.farmacia.medicamento.values.Nombre;
import org.example.vent.farmacia.medicamento.values.Pais;

import java.util.Objects;

public class Laboratorio extends Entity<LaboratorioID> {
    protected Pais pais;
    protected Nombre nombre;

    public Laboratorio(LaboratorioID entityId, Pais pais, Nombre nombre) {
        super(entityId);
        this.pais = pais;
        this.nombre = nombre;
    }

    public void cambiarNombreLaboratorio(Nombre nombreModificado){
        this.nombre = nombre.cambiarNombre(Objects.requireNonNull(nombreModificado));
    }
}
