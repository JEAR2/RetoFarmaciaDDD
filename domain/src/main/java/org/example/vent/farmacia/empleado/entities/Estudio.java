package org.example.vent.farmacia.empleado.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.empleado.values.DescripcionEstudios;
import org.example.vent.farmacia.empleado.values.EstudioID;

import java.util.Objects;

public class Estudio extends Entity<EstudioID> {
    protected DescripcionEstudios descripcionEstudios;

    public Estudio(EstudioID entityId, DescripcionEstudios descripcionEstudios) {
        super(entityId);
        this.descripcionEstudios = descripcionEstudios;
    }
    /*
    public void actualizarDescripcion(DescripcionEstudios.Type tipo, String nombre,Integer duracion){
        this.descripcionEstudios = descripcionEstudios.cambiarDescripcion(tipo,nombre,duracion);
    }
    */

    public void actualizarDescripcionEstudios(DescripcionEstudios descripcionModicar){
        this.descripcionEstudios = descripcionEstudios.cambiarDescripcion(Objects.requireNonNull(descripcionModicar));

    }


}
