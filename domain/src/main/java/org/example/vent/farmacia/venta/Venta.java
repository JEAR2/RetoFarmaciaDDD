package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.Empleado;
import org.example.vent.farmacia.empleado.EmpleadoEventChange;
import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.venta.entities.Cliente;
import org.example.vent.farmacia.venta.entities.Factura;
import org.example.vent.farmacia.venta.events.*;
import org.example.vent.farmacia.venta.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Venta extends AggregateEvent<VentaID> {
    protected Cliente cliente;
    protected Factura factura;
    protected Set<MedicamentoID> medicamentosID;

    public Venta(VentaID ventaID, ClienteID clienteID,Nombre nombre) {
        super(ventaID);
        appendChange(new VentaCreada(ventaID,clienteID,nombre)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaID ventaID){
        super(ventaID);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaID ventaID, List<DomainEvent> events){
        var venta = new Venta(ventaID);
        events.forEach(venta::applyEvent);
        return venta;
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
