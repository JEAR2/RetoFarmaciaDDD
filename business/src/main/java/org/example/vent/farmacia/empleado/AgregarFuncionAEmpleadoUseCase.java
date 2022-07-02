package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.empleado.commands.AgregarFuncionAEmpleadoCommand;
import org.example.vent.farmacia.medicamento.Medicamento;

public class AgregarFuncionAEmpleadoUseCase extends UseCase<RequestCommand<AgregarFuncionAEmpleadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFuncionAEmpleadoCommand> agregarFuncionAEmpleadoCommandRequestCommand) {
        var command = agregarFuncionAEmpleadoCommandRequestCommand.getCommand();
        var empleado = Empleado.from(
                command.getEmpleadoID(),repository().getEventsBy(command.getEmpleadoID().value())
        );

        empleado.agregarFuncion(command.getFuncionID(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
