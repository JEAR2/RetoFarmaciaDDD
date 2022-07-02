package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.vent.farmacia.medicamento.events.UbicacionDeMedicamentoCambiada;

import java.util.List;

public class NotificacionCambiarUbicacionMedicamentoUseCase extends UseCase<TriggeredEvent<UbicacionDeMedicamentoCambiada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<UbicacionDeMedicamentoCambiada> ubicacionDeMedicamentoCambiadaTriggeredEvent) {

        var event = ubicacionDeMedicamentoCambiadaTriggeredEvent.getDomainEvent();

        var service = getService(UbicacionServiceMedicamento.class).orElseThrow();

        String body = String.format("La ubicacion del medicamento ha sido cambiada");
        service.cambiarUbicacionMedicamento(event.medicamentoID(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
