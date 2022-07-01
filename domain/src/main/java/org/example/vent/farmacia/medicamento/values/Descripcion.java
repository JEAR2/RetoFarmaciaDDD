package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public Descripcion cambiarDescripcion(Descripcion descripcion){
        return new Descripcion(Objects.requireNonNull(descripcion.value()));
    }
}
