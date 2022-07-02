package org.example.vent.farmacia.empleado.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.Venta;
import org.example.vent.farmacia.venta.commands.CrearVentaCommand;
import org.example.vent.farmacia.venta.events.VentaCreada;
import org.example.vent.farmacia.venta.values.ClienteID;
import org.example.vent.farmacia.venta.values.Nombre;
import org.example.vent.farmacia.venta.values.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearVentaUseCaseTest {
    @Test
    public void crearVenta(){
        //Arrange
        ClienteID clienteID = ClienteID.of("c1");
        VentaID ventaID = VentaID.of("v1");
        Nombre nombre = new Nombre("Juan");

        var command = new CrearVentaCommand(ventaID,clienteID,nombre);

        var useCase = new CrearVentaUseCase();

        //Act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        VentaCreada event = (VentaCreada) events.get(0);
        Assertions.assertEquals("Juan",event.getNombre().value());
        Assertions.assertEquals(VentaID.of("v1"),event.ventaID());
        Assertions.assertEquals(ClienteID.of("c1"),event.getClienteID());
    }
}