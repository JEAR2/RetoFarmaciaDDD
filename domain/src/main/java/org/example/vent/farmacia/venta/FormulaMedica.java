package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.Entity;

public class FormulaMedica extends Entity<FormulaMedicaID> {
    protected DetalleFormulaMedica detalleFormulaMedica;
    protected FechaFormulaMedica fechaFormulaMedica;

    public FormulaMedica(FormulaMedicaID entityId, DetalleFormulaMedica detalleFormulaMedica, FechaFormulaMedica fechaFormulaMedica) {
        super(entityId);
        this.detalleFormulaMedica = detalleFormulaMedica;
        this.fechaFormulaMedica = fechaFormulaMedica;
    }


}
