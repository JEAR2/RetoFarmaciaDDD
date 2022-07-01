package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<String> {
    private final String value;

    public Celular(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public Celular cambiarCelular(Celular celular){
        return new Celular(Objects.requireNonNull(celular.value()));
    }
}
