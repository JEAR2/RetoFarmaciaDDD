package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.empleado.commands.CrearEmpleadoCommand;

public class CrearEmpleadoUseCase extends UseCase<RequestCommand<CrearEmpleadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEmpleadoCommand> crearEmpleadoCommandRequestCommand) {
        var command = crearEmpleadoCommandRequestCommand.getCommand();
        var empleado = new Empleado(command.getEmpleadoID(),command.getNombre(),command.getCelular(),command.getCorreo(),command.getRolID(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
