package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.ValueObject;

public class Presentacion implements ValueObject<String> {
    private final String value;

    public Presentacion(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
