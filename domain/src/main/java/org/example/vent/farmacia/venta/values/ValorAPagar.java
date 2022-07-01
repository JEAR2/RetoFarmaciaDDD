package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class ValorAPagar implements ValueObject<Double> {
    private final Double value;

    public ValorAPagar(Double value) {
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }
}
