package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.medicamento.Medicamento;
import org.example.vent.farmacia.medicamento.commands.CambiarDescripcionTipoDeMedicamentoCommand;

public class CambiarDescripcionTipoDeMedicamentoUseCase extends UseCase<RequestCommand<CambiarDescripcionTipoDeMedicamentoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDescripcionTipoDeMedicamentoCommand> cambiarDescripcionTipoDeMedicamentoCommandRequestCommand) {
        var command = cambiarDescripcionTipoDeMedicamentoCommandRequestCommand.getCommand();
        var medicamento = Medicamento.from(command.getMedicamentoID(),repository().getEventsBy(command.getMedicamentoID().value()));
        medicamento.actualizarDesccripcionTipoMedicamento(command.getTipoMedicamentoID(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(medicamento.getUncommittedChanges()));
    }
}
