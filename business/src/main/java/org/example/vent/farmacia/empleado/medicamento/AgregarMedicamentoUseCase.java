package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.medicamento.Medicamento;
import org.example.vent.farmacia.medicamento.commands.CrearMedicamentoCommand;

public class AgregarMedicamentoUseCase extends UseCase<RequestCommand<CrearMedicamentoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMedicamentoCommand> crearMedicamentoCommandRequestCommand) {
        var command = crearMedicamentoCommandRequestCommand.getCommand();
        var medicamento = new Medicamento(command.getMedicamentoID(),command.getPresentacion(),command.getUbicacion(),command.getTipoMedicamento());

        emit().onResponse(new ResponseEvents(medicamento.getUncommittedChanges()));
    }
}
