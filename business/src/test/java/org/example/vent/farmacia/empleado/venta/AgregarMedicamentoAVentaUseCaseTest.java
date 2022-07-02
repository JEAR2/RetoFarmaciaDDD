package org.example.vent.farmacia.empleado.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.commands.AgregarFuncionAEmpleadoCommand;
import org.example.vent.farmacia.medicamento.values.Descripcion;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.empleado.values.FuncionID;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.MedicamentoCreado;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.medicamento.values.Presentacion;
import org.example.vent.farmacia.medicamento.values.TipoMedicamentoID;
import org.example.vent.farmacia.medicamento.values.Ubicacion;
import org.example.vent.farmacia.venta.commands.AgregarMedicamentoAVentaCommand;
import org.example.vent.farmacia.venta.events.MedicamentoAgregado;
import org.example.vent.farmacia.venta.events.VentaCreada;
import org.example.vent.farmacia.venta.values.ClienteID;
import org.example.vent.farmacia.venta.values.Nombre;
import org.example.vent.farmacia.venta.values.VentaID;
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
class AgregarMedicamentoAVentaUseCaseTest {
    @InjectMocks
    AgregarMedicamentoAVentaUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void agregarMedicamentoAVenta(){
        //Arrange
        VentaID ventaID = VentaID.of("v1");
        MedicamentoID medicamentoID = MedicamentoID.of("m1");
        var command = new AgregarMedicamentoAVentaCommand(ventaID,medicamentoID);
        when(repository.getEventsBy(ventaID.value())).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (MedicamentoAgregado)events.get(0);
        Assertions.assertEquals(MedicamentoID.of("m1"),event.medicamentoID());
    }

    private List<DomainEvent> history() {
        VentaID ventaID = VentaID.of("v1");
        ClienteID clienteID = ClienteID.of("c1");
        Nombre nombre = new Nombre("jear");
        MedicamentoID medicamentoID = MedicamentoID.of("m1");
        Presentacion presentacion = new Presentacion("presentacion");
        Ubicacion ubicacion = new Ubicacion("ubicacion");
        TipoMedicamentoID tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        Descripcion descripcionTipoMedicamento = new Descripcion("Destalle de tipo de medicamento");
        TipoMedicamento tipoMedicamento = new TipoMedicamento(tipoMedicamentoID,descripcionTipoMedicamento);
        return List.of(
              new MedicamentoCreado(medicamentoID,presentacion,ubicacion,tipoMedicamento),
              new VentaCreada(ventaID,clienteID,nombre)
        );

    }
}

