package org.example.vent.farmacia.empleado.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.empleado.values.Descripcion;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.empleado.values.FuncionID;

public class AgregarFuncionAEmpleadoCommand extends Command {
    private final EmpleadoID empleadoID;
    private final  FuncionID funcionID;
    private final Descripcion descripcion;

    public AgregarFuncionAEmpleadoCommand(EmpleadoID empleadoID, FuncionID funcionID, Descripcion descripcion) {
        this.empleadoID = empleadoID;
        this.funcionID = funcionID;
        this.descripcion = descripcion;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }


    public FuncionID getFuncionID() {
        return funcionID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
