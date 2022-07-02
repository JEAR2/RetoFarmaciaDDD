package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class DetalleFormulaMedica implements ValueObject<String> {
    private final String valor;

    public DetalleFormulaMedica(String valor) {
        this.valor = valor;
    }

    @Override
    public String value() {
        return valor;
    }
}
