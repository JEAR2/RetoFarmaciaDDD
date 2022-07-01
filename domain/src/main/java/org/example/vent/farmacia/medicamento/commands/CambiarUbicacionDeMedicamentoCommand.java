package org.example.vent.farmacia.medicamento.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Ubicacion;

public class CambiarUbicacionDeMedicamentoCommand extends Command {
    private final MedicamentoID medicamentoID;
    private final Ubicacion ubicacion;

    public CambiarUbicacionDeMedicamentoCommand(MedicamentoID medicamentoID, Ubicacion ubicacion) {
        this.medicamentoID = medicamentoID;
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }
}
