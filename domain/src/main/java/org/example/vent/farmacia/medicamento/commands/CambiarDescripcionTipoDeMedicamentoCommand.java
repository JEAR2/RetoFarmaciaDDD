package org.example.vent.farmacia.medicamento.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.values.Descripcion;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.TipoMedicamentoID;

public class CambiarDescripcionTipoDeMedicamentoCommand extends Command{

    private final MedicamentoID medicamentoID;
    private final TipoMedicamentoID tipoMedicamentoID;
    private final Descripcion descripcion;


    public CambiarDescripcionTipoDeMedicamentoCommand(MedicamentoID medicamentoID, TipoMedicamentoID tipoMedicamentoID, Descripcion descripcion) {
        this.medicamentoID = medicamentoID;
        this.tipoMedicamentoID = tipoMedicamentoID;
        this.descripcion = descripcion;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public TipoMedicamentoID getTipoMedicamentoID() {
        return tipoMedicamentoID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
