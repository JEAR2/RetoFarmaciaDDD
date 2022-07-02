package org.example.vent.farmacia.medicamento.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Nombre;
import org.example.vent.farmacia.medicamento.values.ProveedorID;

public class CambiarNombreDeProveedorCommand extends Command {
    private final ProveedorID proveedorID;
    private final Nombre nombre;
    private final MedicamentoID medicamentoID;

    public CambiarNombreDeProveedorCommand(ProveedorID proveedorID, Nombre nombre, MedicamentoID medicamentoID) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.medicamentoID = medicamentoID;
    }

    public ProveedorID proveedorID() {
        return proveedorID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public MedicamentoID medicamentoID() {
        return medicamentoID;
    }
}
