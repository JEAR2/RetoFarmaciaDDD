package org.example.vent.farmacia.medicamento.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.medicamento.values.*;

public class AgregarProveedorMedicamentoCommand extends Command {
    private final MedicamentoID medicamentoID;
    private final ProveedorID proveedorID;
    private final Direccion direccion;
    private final Celular celular;
    private final Nombre nombre;

    public AgregarProveedorMedicamentoCommand(MedicamentoID medicamentoID, ProveedorID proveedorID, Direccion direccion, Celular celular, Nombre nombre) {
        this.medicamentoID = medicamentoID;
        this.proveedorID = proveedorID;
        this.direccion = direccion;
        this.celular = celular;
        this.nombre = nombre;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public ProveedorID getProveedorID() {
        return proveedorID;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
