package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.EventChange;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.venta.entities.Factura;
import org.example.vent.farmacia.venta.events.*;

import java.util.HashSet;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.cliente = event.cliente();
            venta.factura = null;
            venta.medicamentosID = new HashSet<>();
        });

        apply((MedicamentoAgregado event)->{
            venta.medicamentosID.add(event.medicamentoID());
        });

        apply((MedicamentoEliminado event)->{
            MedicamentoID medicamentoID = venta.getMedicamentoID(event.medicamentoID())
                    .orElseThrow(()-> new IllegalArgumentException());
            venta.medicamentosID.remove(medicamentoID);
        });

        apply((FacturaCreada event)->{
            venta.factura = new Factura(
                    event.facturaID(),
                    event.fechaFactura(),
                    event.detalleFactura(),
                    event.valorAPagar()
            );
        });
        apply((ClienteAgregado event)->{
            venta.cliente = event.cliente();
        });

    }
}
