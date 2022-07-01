package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.CambiarDescripcionTipoDeMedicamentoUseCase;
import org.example.vent.farmacia.medicamento.commands.CambiarDescripcionTipoDeMedicamentoCommand;
import org.example.vent.farmacia.medicamento.commands.CambiarUbicacionDeMedicamentoCommand;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.DescripcionTipoDeMedicamentoActualizada;
import org.example.vent.farmacia.medicamento.events.MedicamentoCreado;
import org.example.vent.farmacia.medicamento.events.UbicacionDeMedicamentoCambiada;
import org.example.vent.farmacia.medicamento.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarUbicacionDeMedicamentoUseCaseTest {
    @InjectMocks
    CambiarUbicacionDeMedicamentoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void cambiarUbicacionDeMedicamento(){
        MedicamentoID medicamentoID = MedicamentoID.of("1");
        Ubicacion ubicacion = new Ubicacion("Nueva Ubicacion");

        var command = new CambiarUbicacionDeMedicamentoCommand(medicamentoID,ubicacion);

        when(repository.getEventsBy(medicamentoID.value())).thenReturn(historico());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (UbicacionDeMedicamentoCambiada)events.get(0);
        Assertions.assertEquals("Nueva Ubicacion",event.ubicacion().value());

    }

    private List<DomainEvent> historico() {
        TipoMedicamentoID tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        Descripcion descripcion = new Descripcion("Descripcion");
        TipoMedicamento tipoMedicamento = new TipoMedicamento(tipoMedicamentoID,descripcion);

        Presentacion presentacion = new Presentacion("Una presentacion");
        Ubicacion ubicacion = new Ubicacion("Nueva Ubicacion");

        MedicamentoID medicamentoID = MedicamentoID.of("1");


        return List.of(
                new MedicamentoCreado(medicamentoID,presentacion,ubicacion,tipoMedicamento)
        );
    }

}