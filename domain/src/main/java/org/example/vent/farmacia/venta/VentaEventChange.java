package org.example.vent.farmacia.venta;

import co.com.sofka.domain.generic.EventChange;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;
import org.example.vent.farmacia.venta.events.MedicamentoAgregado;
import org.example.vent.farmacia.venta.events.MedicamentoEliminado;
import org.example.vent.farmacia.venta.events.VentaCreada;

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

    }
}
