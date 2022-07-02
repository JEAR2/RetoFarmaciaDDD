package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.vent.farmacia.empleado.events.CelularEmpleadoCambiado;
import org.example.vent.farmacia.empleado.medicamento.UbicacionServiceMedicamento;

import java.util.List;

public class NotificacionCamciarCelularEmpleadoUseCase extends UseCase<TriggeredEvent<CelularEmpleadoCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CelularEmpleadoCambiado> celularEmpleadoCambiadoTriggeredEvent) {
        var event = celularEmpleadoCambiadoTriggeredEvent.getDomainEvent();

        var service = getService(CelularServiceEmplado.class).orElseThrow();

        String body = String.format("El número de celular ha sido cambiado");
        service.cambiarCelularEmpleado(event.empleadoID(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
