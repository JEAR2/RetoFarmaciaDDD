package org.example.vent.farmacia.venta.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.venta.values.VentaID;

public class AgregarMedicamentoAVentaCommand extends Command {
    private final VentaID ventaID;
    private final MedicamentoID medicamentoID;

    public AgregarMedicamentoAVentaCommand(VentaID ventaID, MedicamentoID medicamentoID) {
        this.ventaID = ventaID;
        this.medicamentoID = medicamentoID;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}
