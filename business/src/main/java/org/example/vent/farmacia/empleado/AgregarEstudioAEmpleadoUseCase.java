package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.empleado.commands.AgregarEstudioAEmpleadoCommand;

public class AgregarEstudioAEmpleadoUseCase extends UseCase<RequestCommand<AgregarEstudioAEmpleadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEstudioAEmpleadoCommand> agregarEstudioAEmpleadoCommandRequestCommand) {
        var command = agregarEstudioAEmpleadoCommandRequestCommand.getCommand();
        var empleado = Empleado.from(
                command.getEmpleadoID(),repository().getEventsBy(command.getEmpleadoID().value())
        );
        empleado.agregarEstudio(command.getEstudioID(),command.getDescripcionEstudios());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
