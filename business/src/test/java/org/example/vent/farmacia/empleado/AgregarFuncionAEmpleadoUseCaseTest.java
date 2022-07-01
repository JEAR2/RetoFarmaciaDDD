package org.example.vent.farmacia.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.commands.AgregarFuncionAEmpleadoCommand;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.events.EmpleadoCreado;
import org.example.vent.farmacia.empleado.events.FuncionAgregada;
import org.example.vent.farmacia.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarFuncionAEmpleadoUseCaseTest {
    @InjectMocks
    AgregarFuncionAEmpleadoUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void agregarFuncionAEmpleado(){
        //Arrange
        EmpleadoID empleadoID = EmpleadoID.of("john");
        Descripcion descripcion = new Descripcion("Funcion 1","Nueva descripcion");
        FuncionID funcionID = FuncionID.of("maquina1");
        String detalle = "";

        var command = new AgregarFuncionAEmpleadoCommand(empleadoID, funcionID, detalle);
        when(repository.getEventsBy("john")).thenReturn(historico());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (FuncionAgregada)events.get(0);
        Assertions.assertEquals("Funcion 1",event.funcionID().value());
        Assertions.assertEquals("Nueva descripcion",event.funcionID());
    }

    private List<DomainEvent> historico() {
        return List.of(new EmpleadoCreado(
                new Nombre("john"),
                new Celular("3231"),
                new Correo("jhedacro"),
                new Rol(new RolID(),new Descripcion("desc1","Desccripcion rol 1"))
        ));
    }

}