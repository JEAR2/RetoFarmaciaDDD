package org.example.vent.farmacia.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.venta.values.DetalleFactura;
import org.example.vent.farmacia.venta.values.FacturaID;
import org.example.vent.farmacia.venta.values.FechaFactura;
import org.example.vent.farmacia.venta.values.ValorAPagar;

public class FacturaCreada extends DomainEvent {
    private final FacturaID facturaID;
    private final FechaFactura fechaFactura;
    private final DetalleFactura detalleFactura;
    private final ValorAPagar valorAPagar;

    public FacturaCreada(FacturaID facturaID, FechaFactura fechaFactura, DetalleFactura detalleFactura, ValorAPagar valorAPagar) {
        super("org.example.vent.farmacia.FacturaCreada");
        this.facturaID = facturaID;
        this.fechaFactura = fechaFactura;
        this.detalleFactura = detalleFactura;
        this.valorAPagar = valorAPagar;
    }

    public DetalleFactura detalleFactura() {
        return detalleFactura;
    }

    public FacturaID facturaID() {
        return facturaID;
    }

    public ValorAPagar valorAPagar() {
        return valorAPagar;
    }

    public FechaFactura fechaFactura() {
        return fechaFactura;
    }
}
