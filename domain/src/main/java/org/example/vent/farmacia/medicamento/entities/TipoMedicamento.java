package org.example.vent.farmacia.medicamento.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.medicamento.values.Descripcion;
import org.example.vent.farmacia.medicamento.values.TipoMedicamentoID;

import java.util.Objects;

public class TipoMedicamento extends Entity<TipoMedicamentoID> {
    protected Descripcion descripcion;

    public TipoMedicamento(TipoMedicamentoID tipoMedicamentoID, Descripcion descripcion) {
        super(tipoMedicamentoID);
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcionModificada){
        this.descripcion = descripcion.cambiarDescripcion(Objects.requireNonNull(descripcionModificada).value());
    }
}
