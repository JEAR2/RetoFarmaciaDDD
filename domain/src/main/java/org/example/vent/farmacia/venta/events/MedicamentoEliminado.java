package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;

public class MedicamentoEliminado extends DomainEvent {
    private final MedicamentoID medicamentoID;

    public MedicamentoEliminado(MedicamentoID medicamentoID) {
        super("org.example.vent.farmacia.MedicamentoEliminado");
        this.medicamentoID = medicamentoID;
    }

    public MedicamentoID medicamentoID() {
        return medicamentoID;
    }
}
