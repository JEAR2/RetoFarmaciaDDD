package org.example.vent.farmacia.medicamento.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Presentacion;
import org.example.vent.farmacia.medicamento.values.Ubicacion;

public class CrearMedicamentoCommand extends Command {
    private final MedicamentoID medicamentoID;
    private final Presentacion presentacion;
    private final Ubicacion ubicacion;
    private final TipoMedicamento tipoMedicamento;

    public CrearMedicamentoCommand(MedicamentoID medicamentoID, Presentacion presentacion, Ubicacion ubicacion, TipoMedicamento tipoMedicamento) {
        this.medicamentoID = medicamentoID;
        this.presentacion = presentacion;
        this.ubicacion = ubicacion;
        this.tipoMedicamento = tipoMedicamento;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }
}
