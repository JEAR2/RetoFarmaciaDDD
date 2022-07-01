package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.venta.entities.Cliente;
import org.example.vent.farmacia.venta.entities.Factura;
import org.example.vent.farmacia.venta.events.*;
import org.example.vent.farmacia.venta.values.*;

import java.util.Optional;
import java.util.Set;

public class Venta extends AggregateEvent<VentaID> {
    protected Cliente cliente;
    protected Factura factura;
    protected Set<MedicamentoID> medicamentosID;

    public Venta(VentaID ventaID, Cliente cliente) {
        super(ventaID);
        appendChange(new VentaCreada(ventaID,cliente)).apply();
        subscribe(new VentaEventChange(this));
    }

    public void agregarMedicamnento(MedicamentoID medicamentoID){
        appendChange(new MedicamentoAgregado(medicamentoID)).apply();
    }

    public void eliminarMedicamento(MedicamentoID medicamentoID){
        appendChange(new MedicamentoEliminado(medicamentoID)).apply();
    }

    public void crearFactura(FacturaID facturaID, FechaFactura fechaFactura, DetalleFactura detalleFactura, ValorAPagar valorAPagar){
        appendChange(new FacturaCreada(facturaID,fechaFactura,detalleFactura,valorAPagar)).apply();
    }

    public void agregarCliente(Cliente cliente){
        appendChange(new ClienteAgregado(cliente)).apply();
    }

    public Optional<MedicamentoID> getMedicamentoID(MedicamentoID medicamentoID){
        return medicamentosID().stream().filter(medicamento -> medicamento.equals(medicamentoID)).findFirst();
    }

    public Cliente cliente() {
        return cliente;
    }

    public Factura factura() {
        return factura;
    }

    public Set<MedicamentoID> medicamentosID() {
        return medicamentosID;
    }
}
