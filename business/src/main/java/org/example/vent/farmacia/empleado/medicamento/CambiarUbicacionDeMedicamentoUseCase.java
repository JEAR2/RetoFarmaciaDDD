package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.medicamento.Medicamento;
import org.example.vent.farmacia.medicamento.commands.CambiarUbicacionDeMedicamentoCommand;

public class CambiarUbicacionDeMedicamentoUseCase extends UseCase<RequestCommand<CambiarUbicacionDeMedicamentoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarUbicacionDeMedicamentoCommand> cambiarUbicacionDeMedicamentoCommandRequestCommand) {
        var command = cambiarUbicacionDeMedicamentoCommandRequestCommand.getCommand();
        var medicamento = Medicamento.from(command.getMedicamentoID(),repository().getEventsBy(command.getMedicamentoID().value()));
        medicamento.cambiarUbicacionMedicamento(command.getMedicamentoID(),command.getUbicacion());
        emit().onResponse(new ResponseEvents(medicamento.getUncommittedChanges()));
    }
}

