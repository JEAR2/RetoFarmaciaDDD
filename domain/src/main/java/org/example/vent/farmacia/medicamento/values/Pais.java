package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.ValueObject;

public class Pais implements ValueObject<String> {
    private final String value;

    public Pais(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
