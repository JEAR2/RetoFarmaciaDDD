package org.example.vent.farmacia.medicamento.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.medicamento.values.Celular;
import org.example.vent.farmacia.medicamento.values.Direccion;
import org.example.vent.farmacia.medicamento.values.Nombre;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

import java.util.Objects;
import java.util.Set;

public class Proveedor extends Entity<ProveedorID> {
    protected Direccion direccion;
    protected Celular celular;
    protected Nombre nombre;
    protected Set<Laboratorio> laboratorios;

    public Proveedor(ProveedorID entityId, Direccion direccion, Celular celular, Nombre nombre) {
        super(entityId);
        this.direccion = direccion;
        this.celular = celular;
        this.nombre = nombre;
    }

    public void cambiarNombreProveedor(Nombre nombre){
        this.nombre = nombre.cambiarNombre(Objects.requireNonNull(nombre));
    }
    public void cambiarCelularProveedor(Celular celular){
        this.celular = celular.cambiarCelular(Objects.requireNonNull(celular));
    }

}
