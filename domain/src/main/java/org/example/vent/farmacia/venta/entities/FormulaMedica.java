package org.example.vent.farmacia.venta.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.venta.values.DetalleFormulaMedica;
import org.example.vent.farmacia.venta.values.FechaFormulaMedica;
import org.example.vent.farmacia.venta.values.FormulaMedicaID;

public class FormulaMedica extends Entity<FormulaMedicaID> {
    protected DetalleFormulaMedica detalleFormulaMedica;
    protected FechaFormulaMedica fechaFormulaMedica;

    public FormulaMedica(FormulaMedicaID entityId, DetalleFormulaMedica detalleFormulaMedica, FechaFormulaMedica fechaFormulaMedica) {
        super(entityId);
        this.detalleFormulaMedica = detalleFormulaMedica;
        this.fechaFormulaMedica = fechaFormulaMedica;
    }


}
