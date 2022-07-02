package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.commands.CrearEmpleadoCommand;
import org.example.vent.farmacia.empleado.events.EmpleadoCreado;
import org.example.vent.farmacia.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CrearEmpleadoUseTest {
    @Test
    void crearEmpleado(){
        //Arrange
        EmpleadoID empleadoID = EmpleadoID.of("e1");
        Nombre nombre = new Nombre("Edward");
        Celular celular = new Celular("312423142");
        Correo correo = new Correo("jhedacro@gmail.com");
        RolID rolID = RolID.of("r1");
        Descripcion descripcion = new Descripcion("descripcion","Una descripcion");

        var command = new CrearEmpleadoCommand(empleadoID,nombre,celular,correo,rolID,descripcion);

        var useCase = new CrearEmpleadoUseCase();
        //Act
        List<DomainEvent> events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        EmpleadoCreado event = (EmpleadoCreado) events.get(0);
        Assertions.assertEquals("Edward",event.nombre().value());

    }

}
