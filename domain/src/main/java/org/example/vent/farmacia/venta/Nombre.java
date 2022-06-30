package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
