package org.example.vent.farmacia.empleado.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class AgregarFuncionAEmpleadoCommand extends Command {
    private final EmpleadoID empleadoID;
    private final  FuncionID funcionID;
    private final String detalle;

    public AgregarFuncionAEmpleadoCommand(EmpleadoID empleadoID, FuncionID funcionID, String detalle) {
        this.empleadoID = empleadoID;
        this.funcionID = funcionID;
        this.detalle = detalle;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }


    public FuncionID getFuncionID() {
        return funcionID;
    }

    public String getDetalle() {
        return detalle;
    }
}
