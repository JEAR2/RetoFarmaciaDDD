package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

public class Celular implements ValueObject<String> {
    private final String value;

    public Celular(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
