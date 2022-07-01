package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<Descripcion.Props> {

    private final String nombre;
    private final String detalle;

    public Descripcion(String nombre, String detalle){
        this.nombre = Objects.requireNonNull(nombre);
        this.detalle = Objects.requireNonNull(detalle);
    }
    @Override
    public Descripcion.Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String detalle() {
                return detalle;
            }
        };
    }

    public Descripcion cambiarDescripcion(String descripcion){
        return new Descripcion(nombre,descripcion);
    }

    public interface Props {
        String nombre();
        String detalle();
    }
}
