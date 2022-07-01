package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.Ubicacion;

public class UbicacionDeMedicamentoCambiada extends DomainEvent {
    private final Ubicacion ubicacion;

    public UbicacionDeMedicamentoCambiada(Ubicacion ubicacion) {
        super("org.example.vent.farmacia.UbicacionDeMedicamentoCambiada");
        this.ubicacion = ubicacion;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }
}
