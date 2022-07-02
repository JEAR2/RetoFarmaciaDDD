package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionEstudios implements ValueObject<String> {

    private final String value;

    public DescripcionEstudios(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public DescripcionEstudios cambiarDescripcion(DescripcionEstudios descripcionEstudios){
        return new DescripcionEstudios(descripcionEstudios.value());
    }


}
