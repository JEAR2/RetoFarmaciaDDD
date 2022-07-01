package org.example.vent.farmacia.venta.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.vent.farmacia.venta.values.DetalleFactura;
import org.example.vent.farmacia.venta.values.FacturaID;
import org.example.vent.farmacia.venta.values.FechaFactura;
import org.example.vent.farmacia.venta.values.ValorAPagar;

public class Factura extends Entity<FacturaID> {
    protected FechaFactura fechaFactura;
    protected DetalleFactura detalleFactura;
    protected ValorAPagar valorAPagar;

    public Factura(FacturaID facturaID, FechaFactura fechaFactura, DetalleFactura detalleFactura, ValorAPagar valorAPagar) {
        super(facturaID);
        this.fechaFactura = fechaFactura;
        this.detalleFactura = detalleFactura;
        this.valorAPagar = valorAPagar;
    }

    public void cambiarDetalleFactura(DetalleFactura detalleFactura){
        this.detalleFactura = detalleFactura.cambiarDetalleFactura(detalleFactura.value());
    }
}
