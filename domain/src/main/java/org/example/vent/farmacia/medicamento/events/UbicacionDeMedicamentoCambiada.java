package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Ubicacion;

public class UbicacionDeMedicamentoCambiada extends DomainEvent {
    private final Ubicacion ubicacion;
    private final MedicamentoID medicamentoID;

    public UbicacionDeMedicamentoCambiada( MedicamentoID medicamentoID,Ubicacion ubicacion) {
        super("org.example.vent.farmacia.UbicacionDeMedicamentoCambiada");
        this.ubicacion = ubicacion;
        this.medicamentoID = medicamentoID;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public MedicamentoID medicamentoID() {
        return medicamentoID;
    }
}
