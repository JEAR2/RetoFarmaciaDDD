package org.example.vent.farmacia.empleado.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.empleado.values.DescripcionEstudios;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.empleado.values.EstudioID;

public class AgregarEstudioAEmpleadoCommand extends Command {
    private final EmpleadoID empleadoID;
    private final EstudioID estudioID;
    private final DescripcionEstudios descripcionEstudios;

    public AgregarEstudioAEmpleadoCommand(EmpleadoID empleadoID, EstudioID estudioID, DescripcionEstudios descripcionEstudios) {
        this.empleadoID = empleadoID;
        this.estudioID = estudioID;
        this.descripcionEstudios = descripcionEstudios;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }

    public EstudioID getEstudioID() {
        return estudioID;
    }

    public DescripcionEstudios getDescripcionEstudios() {
        return descripcionEstudios;
    }
}
