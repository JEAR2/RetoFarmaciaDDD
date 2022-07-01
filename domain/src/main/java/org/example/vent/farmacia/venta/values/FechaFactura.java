package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;

public class FechaFactura implements ValueObject<Date> {
    private final Date value;

    public FechaFactura(Date value) {
        this.value = value;
    }


    @Override
    public Date value() {
        return value;
    }
}
