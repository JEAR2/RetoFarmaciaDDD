package org.example.vent.farmacia.medicamento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.medicamento.entities.Proveedor;
import org.example.vent.farmacia.medicamento.entities.TipoMedicamento;
import org.example.vent.farmacia.medicamento.events.*;
import org.example.vent.farmacia.medicamento.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Medicamento extends AggregateEvent<MedicamentoID> {
    protected Presentacion presentacion;
    protected Ubicacion ubicacion;
    protected TipoMedicamento tipoMedicamento;

    protected Set<Proveedor> proveedores;

    public Medicamento(MedicamentoID medicamentoID, Presentacion presentacion, Ubicacion ubicacion, TipoMedicamento tipoMedicamento) {
        super(medicamentoID);
        appendChange(new MedicamentoCreado(medicamentoID,presentacion,ubicacion,tipoMedicamento)).apply();
        subscribe(new MedicamentoEventChange(this));
    }

    private Medicamento(MedicamentoID medicamentoID){
        super(medicamentoID);
        subscribe(new MedicamentoEventChange(this));
    }

    public static Medicamento from(MedicamentoID medicamentoID, List<DomainEvent> events){
        var medicamento = new Medicamento(medicamentoID);
        events.forEach(medicamento::applyEvent);
        return medicamento;
    }


    public void agregarProveedor(ProveedorID proveedorID, Direccion direccion, Celular celular, Nombre nombre){
        appendChange(new ProveedorAgregado(proveedorID,direccion,celular,nombre)).apply();
    }
    public void eliminarProveedor(ProveedorID proveedorID){
        appendChange(new ProveedorEliminado(proveedorID)).apply();
    }

    public void actualizarDesccripcionTipoMedicamento(TipoMedicamentoID tipoMedicamentoID, Descripcion descripcion){
        appendChange(new DescripcionTipoDeMedicamentoActualizada(tipoMedicamentoID,descripcion)).apply();
    }

    public void cambiarNombreDeproveedor(ProveedorID proveedorID, Nombre nombre){
        appendChange(new NombreDeProveedorCambiado(proveedorID,nombre)).apply();
    }

    public void cambiarCalularDeproveedor(ProveedorID proveedorID, Celular celular){
        appendChange(new CelularDeProveedorCambiado(proveedorID,celular)).apply();
    }

    public void cambiarUbicacionMedicamento(MedicamentoID medicamentoID,Ubicacion ubicacion){
        appendChange(new UbicacionDeMedicamentoCambiada(medicamentoID,ubicacion)).apply();
    }

    public Optional<Proveedor> getProveedorPorID(ProveedorID proveedorID){
        return proveedores().stream().filter(proveedor -> proveedor.identity().equals(proveedorID)).findFirst();
    }

    public TipoMedicamento tipoMedicamento() {
        return tipoMedicamento;
    }

    public Presentacion presentacion() {
        return presentacion;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public Set<Proveedor> proveedores() {
        return proveedores;
    }
}
