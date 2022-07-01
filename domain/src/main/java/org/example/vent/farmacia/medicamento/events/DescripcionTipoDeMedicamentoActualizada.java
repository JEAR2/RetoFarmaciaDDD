package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.values.Descripcion;
import org.example.vent.farmacia.medicamento.values.TipoMedicamentoID;

public class DescripcionTipoDeMedicamentoActualizada extends DomainEvent {
    private final TipoMedicamentoID tipoMedicamentoID;
    private final Descripcion descripcion;

    public DescripcionTipoDeMedicamentoActualizada(TipoMedicamentoID tipoMedicamentoID, Descripcion descripcion) {
        super("org.example.vent.farmacia.DescripcionTipoDeMedicamentoActualizada");
        this.tipoMedicamentoID = tipoMedicamentoID;
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public TipoMedicamentoID tipoMedicamentoID() {
        return tipoMedicamentoID;
    }
}
