package org.example.vent.farmacia.empleado.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.RolID;

import java.util.Objects;

public class Rol extends Entity<RolID> {
    protected Descripcion descripcion;

    public Rol(RolID entityId, Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }
    /*
    public void actualizarDescripcion(String nombre,String detalle){
        this.descripcion = descripcion.cambiarDescripcion(nombre,detalle);
    }s
     */

    public void actualizarDescripcion(String descripcionModificar){
        this.descripcion = descripcion.cambiarDescripcion(Objects.requireNonNull(descripcionModificar));
    }
}
