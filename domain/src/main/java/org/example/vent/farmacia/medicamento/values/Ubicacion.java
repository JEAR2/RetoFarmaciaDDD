package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.ValueObject;

public class Ubicacion implements ValueObject<String> {
    private final String value;

    public Ubicacion(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public Ubicacion cambiarubicacion(Ubicacion ubicacion){
        return new Ubicacion(ubicacion.value());
    }
}
