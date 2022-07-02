package org.example.vent.farmacia.empleado.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.empleado.Empleado;
import org.example.vent.farmacia.venta.Venta;
import org.example.vent.farmacia.venta.commands.AgregarMedicamentoAVentaCommand;

public class AgregarMedicamentoAVentaUseCase extends UseCase<RequestCommand<AgregarMedicamentoAVentaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMedicamentoAVentaCommand> agregarMedicamentoAVentaCommandRequestCommand) {

        var command = agregarMedicamentoAVentaCommandRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaID(),repository().getEventsBy(command.getVentaID().value())
        );


       venta.agregarMedicamnento(command.getMedicamentoID());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
