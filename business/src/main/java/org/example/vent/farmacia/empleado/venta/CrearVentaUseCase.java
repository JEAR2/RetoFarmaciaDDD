package org.example.vent.farmacia.empleado.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.venta.Venta;
import org.example.vent.farmacia.venta.commands.CrearVentaCommand;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVentaCommand> crearVentaCommandRequestCommand) {
        var command = crearVentaCommandRequestCommand.getCommand();
        var venta = new Venta(command.getVentaI(), command.getClienteID(),command.getNombre());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
