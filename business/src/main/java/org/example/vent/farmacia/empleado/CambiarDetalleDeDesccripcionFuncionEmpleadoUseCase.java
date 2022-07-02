package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.empleado.commands.CambiarDetalleDeFuncionAEmpleadoCommand;

public class CambiarDetalleDeDesccripcionFuncionEmpleadoUseCase extends UseCase<RequestCommand<CambiarDetalleDeFuncionAEmpleadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDetalleDeFuncionAEmpleadoCommand> cambiarDetalleDeFuncionAEmpleadoCommandRequestCommand) {
        var command = cambiarDetalleDeFuncionAEmpleadoCommandRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoID(),repository().getEventsBy(command.getEmpleadoID().value()));
        empleado.actualizarDetalleDescripcionDeFuncion(command.getFuncionID(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
        
    }
}
