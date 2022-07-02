package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.commands.AgregarProveedorMedicamentoCommand;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.MedicamentoCreado;
import org.example.vent.farmacia.medicamento.events.ProveedorAgregado;
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
class AgregarProveedorAMedicamentoUseCaseTest {
    @InjectMocks
    AgregarProveedorAMedicamentoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarProveedorMedicamento(){
        //arrange
        var medicamentoID = MedicamentoID.of("m1");
        var proveedorID = ProveedorID.of("p");
        var direccion =  new Direccion("calle 2");
        var celular = new Celular("3124");
        var nombre = new Nombre("john");
        var command = new AgregarProveedorMedicamentoCommand(medicamentoID,proveedorID,direccion,celular,nombre);
        when(repository.getEventsBy(medicamentoID.value())).thenReturn(history());

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProveedorAgregado) events.get(0);
        Assertions.assertEquals("p", event.proveedorID().value());
        Assertions.assertEquals("john", event.nombre().value());

    }

    private List<DomainEvent> history() {
        TipoMedicamentoID tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        Descripcion descripcion = new Descripcion("Descripcion");
        TipoMedicamento tipoMedicamento = new TipoMedicamento(tipoMedicamentoID,descripcion);

        Presentacion presentacion = new Presentacion("Una presentacion");
        Ubicacion ubicacion = new Ubicacion("Nueva Ubicacion");

        MedicamentoID medicamentoID = MedicamentoID.of("m1");


        return List.of(
                new MedicamentoCreado(medicamentoID,presentacion,ubicacion,tipoMedicamento)
        );
    }
}