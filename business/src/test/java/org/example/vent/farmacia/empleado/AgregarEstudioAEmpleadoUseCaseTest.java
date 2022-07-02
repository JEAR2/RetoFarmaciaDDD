package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.commands.AgregarEstudioAEmpleadoCommand;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.events.EmpleadoCreado;
import org.example.vent.farmacia.empleado.events.EstudioAgregado;
import org.example.vent.farmacia.empleado.events.FuncionAgregada;
import org.example.vent.farmacia.empleado.values.*;
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
class AgregarEstudioAEmpleadoUseCaseTest {
    @InjectMocks
    AgregarEstudioAEmpleadoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void agregarEstudioAEmpleado(){
        //Arrange
        EmpleadoID empleadoID = EmpleadoID.of("john");
        DescripcionEstudios descripcion = new DescripcionEstudios("DescripcionEstudio");
        EstudioID estudioID = EstudioID.of("e1");

        var command = new AgregarEstudioAEmpleadoCommand(empleadoID,estudioID,descripcion);
        when(repository.getEventsBy("john")).thenReturn(historico());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (EstudioAgregado)events.get(0);
        Assertions.assertEquals(EstudioID.of("e1"),event.estudioID());
        Assertions.assertEquals("DescripcionEstudio",event.descripcionEstudios().value());
    }
    private List<DomainEvent> historico() {
        EmpleadoID empleadoID = EmpleadoID.of("1");
        Nombre nombre = new Nombre("john");
        Celular celular = new Celular("1234");
        Correo correo = new Correo("jhedacro");
        RolID rolID = RolID.of("r1");
        Descripcion descripcionRol = new Descripcion("rol1","Descripcion rol uno");
        Rol rol = new Rol(rolID,descripcionRol);
        FuncionID funcionID = FuncionID.of("f1");
        Descripcion descripcionFuncion = new Descripcion("d1","Descripcion funcion uno");


        return List.of(
                new EmpleadoCreado(nombre,celular,correo,rolID,descripcionRol),
                new FuncionCreada(funcionID,descripcionFuncion)
        );
    }
}