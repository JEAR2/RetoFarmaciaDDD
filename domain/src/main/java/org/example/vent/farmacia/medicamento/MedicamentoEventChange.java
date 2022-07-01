package org.example.vent.farmacia.medicamento;

import co.com.sofka.domain.generic.EventChange;
import org.example.vent.farmacia.medicamento.entities.Proveedor;
import org.example.vent.farmacia.medicamento.events.*;

import java.util.HashSet;

public class MedicamentoEventChange extends EventChange {
    public MedicamentoEventChange(Medicamento medicamento) {
        apply((MedicamentoCreado event)->{
            medicamento.tipoMedicamento = event.tipoMedicamento();
            medicamento.presentacion = event.presentacion();
            medicamento.proveedores = new HashSet<>();
            medicamento.ubicacion = event.ubicacion();

        });

        apply((ProveedorAgregado event)->{
            medicamento.proveedores.add(new Proveedor(
                    event.proveedorID(),
                    event.direccion(),
                    event.celular(),
                    event.nombre()
            ));
        });
        apply((ProveedorEliminado event)->{
            Proveedor proveedor = medicamento.getProveedorPorID(event.proveedorID())
                    .orElseThrow(()-> new IllegalArgumentException("El proveedor no encontrado para el medicamento actual"));
            medicamento.proveedores.remove(proveedor);
        });

        apply((DescripcionTipoDeMedicamentoActualizada event)->{
            medicamento.tipoMedicamento().actualizarDescripcion(event.descripcion());
        });

        apply((NombreDeProveedorCambiado event)->{
            Proveedor proveedor = medicamento.getProveedorPorID(event.proveedorID())
                    .orElseThrow(()-> new IllegalArgumentException("El proveedor no encontrado para el medicamento actual"));
            proveedor.cambiarNombreProveedor(event.nombre());

        });

        apply((CelularDeProveedorCambiado event)->{
            Proveedor proveedor = medicamento.getProveedorPorID(event.proveedorID())
                    .orElseThrow(()-> new IllegalArgumentException("El proveedor no encontrado para el medicamento actual"));
            proveedor.cambiarCelularProveedor(event.celular());
        });


        apply((UbicacionDeMedicamentoCambiada event)->{
            medicamento.ubicacion.cambiarUbicacion(event.ubicacion());
        });

    }

}
