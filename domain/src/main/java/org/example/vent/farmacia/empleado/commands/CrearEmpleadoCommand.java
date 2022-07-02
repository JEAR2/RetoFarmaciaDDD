package org.example.vent.farmacia.empleado.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.empleado.values.*;

public class CrearEmpleadoCommand extends Command {
    private final EmpleadoID empleadoID;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final RolID rolID;
    private final Descripcion descripcion;

    public CrearEmpleadoCommand(EmpleadoID empleadoID, Nombre nombre, Celular celular, Correo correo, RolID rolID, Descripcion descripcion) {
        this.empleadoID = empleadoID;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.rolID = rolID;
        this.descripcion = descripcion;
    }

    public EmpleadoID getEmpleadoID() {
        return empleadoID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Celular getCelular() {
        return celular;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public RolID getRolID() {
        return rolID;
    }

    public Correo getCorreo() {
        return correo;
    }


}
