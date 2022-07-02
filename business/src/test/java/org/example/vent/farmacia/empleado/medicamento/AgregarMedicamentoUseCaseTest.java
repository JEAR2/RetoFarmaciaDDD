package org.example.vent.farmacia.empleado.medicamento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.Medicamento;
import org.example.vent.farmacia.medicamento.commands.CrearMedicamentoCommand;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.MedicamentoCreado;
import org.example.vent.farmacia.medicamento.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.DomainCombiner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgregarMedicamentoUseCaseTest {
    @Test
    void crearMedicamento(){
        //Arrange
        var medicamientID = new MedicamentoID();
        var presentacion = new Presentacion("presentacion");
        var ubicacion = new Ubicacion("ubicacion");
        var tipoMedicamentoID = TipoMedicamentoID.of("tm1");
        var descripcionTipoMedicamento =  new Descripcion("descripcion");

        var tipoMedicamento = new TipoMedicamento(tipoMedicamentoID,descripcionTipoMedicamento);

        var command = new CrearMedicamentoCommand(medicamientID,presentacion,ubicacion,tipoMedicamento);

        var useCase = new AgregarMedicamentoUseCase();

        //Act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //
        MedicamentoCreado event = (MedicamentoCreado)events.get(0);

        Assertions.assertEquals("presentacion",event.presentacion().value());
    }
}