package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.Entity;

public class Factura extends Entity<FacturaID> {
    protected FechaFactura fechaFactura;
    protected DetalleFactura detalleFactura;
    protected ValorAPagar valorAPagar;

    public Factura(FacturaID entityId, FechaFactura fechaFactura, DetalleFactura detalleFactura, ValorAPagar valorAPagar) {
        super(entityId);
        this.fechaFactura = fechaFactura;
        this.detalleFactura = detalleFactura;
        this.valorAPagar = valorAPagar;
    }

    public void cambiarDetalleFactura(DetalleFactura detalleFactura){
        this.detalleFactura = detalleFactura.cambiarDetalleFactura(detalleFactura.value());
    }
}
