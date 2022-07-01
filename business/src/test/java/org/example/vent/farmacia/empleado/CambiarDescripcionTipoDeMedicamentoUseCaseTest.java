package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.commands.CambiarDescripcionTipoDeMedicamentoCommand;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.DescripcionTipoDeMedicamentoActualizada;
import org.example.vent.farmacia.medicamento.events.MedicamentoCreado;
import org.example.vent.farmacia.medicamento.values.*;
import org.example.vent.farmacia.medicamento.values.Descripcion;
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
class CambiarDescripcionTipoDeMedicamentoUseCaseTest {
    @InjectMocks
    CambiarDescripcionTipoDeMedicamentoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void cambiarDescripcionTipoDeMedicamento(){
        //Arrange
        MedicamentoID medicamentoID = MedicamentoID.of("m1");
        TipoMedicamentoID tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        Descripcion descripcion = new Descripcion("Nueva Descripcion");

        var command = new CambiarDescripcionTipoDeMedicamentoCommand(medicamentoID,tipoMedicamentoID,descripcion);
        when(repository.getEventsBy(medicamentoID.value())).thenReturn(historico());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (DescripcionTipoDeMedicamentoActualizada)events.get(0);
        Assertions.assertEquals("Nueva Descripcion",event.descripcion().value());
    }

    private List<DomainEvent> historico() {
        TipoMedicamentoID tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        Descripcion descripcion = new Descripcion("Descripcion");
        TipoMedicamento tipoMedicamento = new TipoMedicamento(tipoMedicamentoID,descripcion);

        Presentacion presentacion = new Presentacion("Una presentacion");
        Ubicacion ubicacion = new Ubicacion("ubicacion");

        MedicamentoID medicamentoID = MedicamentoID.of("m1");


        return List.of(
               new MedicamentoCreado(medicamentoID,presentacion,ubicacion,tipoMedicamento)
        );
    }

}