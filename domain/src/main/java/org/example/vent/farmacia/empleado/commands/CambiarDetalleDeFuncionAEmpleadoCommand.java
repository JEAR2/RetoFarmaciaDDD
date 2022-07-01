package org.example.vent.farmacia.empleado.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class CambiarDetalleDeFuncionAEmpleadoCommand extends Command {
    private final EmpleadoID empleadoID;
    private final FuncionID funcionID;
    private final String descripcion;

    public CambiarDetalleDeFuncionAEmpleadoCommand(EmpleadoID empleadoID, FuncionID funcionID, String descripcion) {
        this.empleadoID = empleadoID;
        this.funcionID = funcionID;
        this.descripcion = descripcion;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }
}
