package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;

public class FechaFormulaMedica implements ValueObject<Date> {
    private final Date valor;

    public FechaFormulaMedica(Date valor) {
        this.valor = valor;
    }

    @Override
    public Date value() {
        return valor;
    }
}
