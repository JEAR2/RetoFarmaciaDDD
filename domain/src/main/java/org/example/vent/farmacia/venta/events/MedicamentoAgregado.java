package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;

public class MedicamentoAgregado extends DomainEvent {
    private final MedicamentoID medicamentoID;

    public MedicamentoAgregado(MedicamentoID medicamentoID) {
        super("org.example.vent.farmacia");
        this.medicamentoID = medicamentoID;
    }

    public MedicamentoID medicamentoID() {
        return medicamentoID;
    }
}
