package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionEstudios implements ValueObject<DescripcionEstudios.Props> {

    private final Type tipo;
    private final String nombre;
    private final Integer duracion;

    public DescripcionEstudios(Type tipo, String nombre, Integer duracion){
        this.tipo = Objects.requireNonNull(tipo);
        this.nombre = Objects.requireNonNull(nombre);
        this.duracion = Objects.requireNonNull(duracion);
    }


    @Override
    public DescripcionEstudios.Props value() {
        return new Props() {
            @Override
            public Type tipo() {
                return tipo;
            }

            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Integer duracion() {
                return duracion;
            }
        };
    }

    public DescripcionEstudios cambiarDescripcion(DescripcionEstudios descripcionEstudios){
        return new DescripcionEstudios(descripcionEstudios.tipo,descripcionEstudios.nombre,descripcionEstudios.duracion);
    }


    public interface Props {
        Type tipo();
        String nombre();
        Integer duracion();
    }

    public enum Type{
        Tecnico,Tecnologo,Profesional,Especializacion
    }
}
