package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class NotificacionCambiarUbicacionMedicamentoUseCaseTest {
    @Mock
    UbicacionServiceMedicamento ubicacionServiceMedicamento;

    @InjectMocks
    NotificacionCambiarUbicacionMedicamentoUseCase useCase;

    @Test
    void cambiarUbicacionMedicamento(){

        MedicamentoID medicamentoID = MedicamentoID.of("m1");
        Ubicacion ubicacion = new Ubicacion("Ubicacion");

        var event = new UbicacionDeMedicamentoCambiada(medicamentoID,ubicacion);
        Mockito.doNothing().when(ubicacionServiceMedicamento).cambiarUbicacionMedicamento(medicamentoID, "La ubicacion del medicamento ha sido cambiada");
        useCase.addServiceBuilder(new ServiceBuilder().addService(ubicacionServiceMedicamento));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(ubicacionServiceMedicamento).cambiarUbicacionMedicamento(medicamentoID, "La ubicacion del medicamento ha sido cambiada");
        Assertions.assertEquals(0, events.size());
    }
}