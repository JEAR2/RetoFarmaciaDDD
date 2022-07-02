package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.vent.farmacia.medicamento.Medicamento;
import org.example.vent.farmacia.medicamento.commands.AgregarProveedorMedicamentoCommand;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;

public class AgregarProveedorAMedicamentoUseCase extends UseCase<RequestCommand<AgregarProveedorMedicamentoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProveedorMedicamentoCommand> agregarProveedorMedicamentoCommandRequestCommand) {
        var command = agregarProveedorMedicamentoCommandRequestCommand.getCommand();
        var medicamento = Medicamento.from(
                command.getMedicamentoID(),repository().getEventsBy(command.getMedicamentoID().value())

        );

        medicamento.agregarProveedor(command.getProveedorID(),command.getDireccion(),command.getCelular(),command.getNombre());

        emit().onResponse(new ResponseEvents(medicamento.getUncommittedChanges()));
    }
}
