package org.example.vent.farmacia.empleado.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.FuncionID;

import java.util.Objects;

public class Funcion extends Entity<FuncionID> {

    protected Descripcion descripcion;

    public Funcion(FuncionID entityId, Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }

    /*
    public void actualizarDescripcion(String nombre,String detalle){
        this.descripcion = descripcion.cambiarDescripcion(nombre,detalle);
    }
    */
    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
