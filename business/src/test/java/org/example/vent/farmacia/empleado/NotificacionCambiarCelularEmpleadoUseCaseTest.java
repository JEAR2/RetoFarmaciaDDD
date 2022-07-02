package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.vent.farmacia.empleado.events.CelularEmpleadoCambiado;
import org.example.vent.farmacia.empleado.medicamento.NotificacionCambiarUbicacionMedicamentoUseCase;
import org.example.vent.farmacia.empleado.medicamento.UbicacionServiceMedicamento;
import org.example.vent.farmacia.empleado.values.Celular;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.medicamento.events.UbicacionDeMedicamentoCambiada;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificacionCambiarCelularEmpleadoUseCaseTest {
    @Mock
    CelularServiceEmplado celularServiceEmplado;

    @InjectMocks
    NotificacionCambiarCelularEmpleadoUseCase useCase;

    @Test
    void cambiarCelularEmpleado(){

        EmpleadoID empleadoID = EmpleadoID.of("m1");
        Celular celular = new Celular("314351107");

        var event = new CelularEmpleadoCambiado(empleadoID,celular);
        Mockito.doNothing().when(celularServiceEmplado).cambiarCelularEmpleado(empleadoID, "El número de celular ha sido cambiado");
        useCase.addServiceBuilder(new ServiceBuilder().addService(celularServiceEmplado));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(celularServiceEmplado).cambiarCelularEmpleado(empleadoID, "El número de celular ha sido cambiado");
        Assertions.assertEquals(0, events.size());
    }
}