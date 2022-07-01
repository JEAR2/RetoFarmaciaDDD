package org.example.vent.farmacia.medicamento.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Presentacion;
import org.example.vent.farmacia.medicamento.values.Ubicacion;

public class MedicamentoCreado extends DomainEvent {
    private final MedicamentoID medicamentoID;
    private final Presentacion presentacion;
    private final Ubicacion ubicacion;
    private final TipoMedicamento tipoMedicamento;


    public MedicamentoCreado(MedicamentoID medicamentoID, Presentacion presentacion, Ubicacion ubicacion, TipoMedicamento tipoMedicamento) {
        super("org.example.vent.farmacia.MedicamentoCreado");
        this.medicamentoID = medicamentoID;
        this.presentacion = presentacion;
        this.ubicacion = ubicacion;
        this.tipoMedicamento = tipoMedicamento;
    }

    public MedicamentoID medicamentoID() {
        return medicamentoID;
    }

    public TipoMedicamento tipoMedicamento() {
        return tipoMedicamento;
    }

    public Presentacion presentacion() {
        return presentacion;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }
}
