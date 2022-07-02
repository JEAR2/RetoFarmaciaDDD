package org.example.vent.farmacia.empleado;

import co.com.sofka.domain.generic.EventChange;
import org.example.vent.farmacia.empleado.entities.Estudio;
import org.example.vent.farmacia.empleado.entities.Funcion;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.events.*;

import java.util.HashSet;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((EmpleadoCreado event)->{
            empleado.correo = event.correo();
            empleado.estudios = new HashSet<>();
            empleado.nombre = event.nombre();
            empleado.celular = event.celular();
            empleado.funciones = new HashSet<>();
            empleado.ventas =  new HashSet<>();
            empleado.rol = new Rol(event.rolID(),event.descripcion());
        });

        apply((FuncionCreada event)->{
            empleado.funciones.add(new Funcion(
                    event.funcionID(),
                    event.descripcion()
            ));
        });

        apply((FuncionAgregada event)->{
            empleado.funciones.add(new Funcion(
                    event.funcionID(),
                    event.descripcion()
            ));
        });

        apply((FuncionEliminada event)->{
            Funcion funcion = empleado.getFuncionPorID(event.funcionID())
                    .orElseThrow(()-> new IllegalArgumentException("La funcion de ha sido encontrada para el empleado"));
            empleado.funciones.remove(funcion);
        });

        apply((CelularEmpleadoCambiado event)->{
            empleado.celular.cambiarCelular(event.celular());
        });

        apply((EstudioAgregado event)->{
            empleado.estudios.add(new Estudio(
                    event.estudioID(),
                    event.descripcionEstudios()
            ));
        });

        apply((DetalleDescripcionDeFuncionActualizada event)->{
            var funcion = empleado.getFuncionPorID(event.funcionID())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuntra la funcion para el ampleado actual"));
            funcion.actualizarDescripcion(event.descripcion());
        });

        apply((DescripcionDeEstudiosActualizada event)->{
            var estudio = empleado.getEstudioPorID(event.estudioID())
                    .orElseThrow(()-> new IllegalArgumentException("estudio no encontrado"));
            estudio.actualizarDescripcionEstudios(event.descripcionEstudios());
        });

        apply((DescripcionDeRolActualizada event)->{
            empleado.rol.actualizarDescripcion(event.descripcion());

        });

        apply((VentaAgregada event)->{
            empleado.ventas.add(event.ventaID());
        });

        apply((VentaEliminada event)->{
            var venta = empleado.getVentaID(event.ventaID())
                    .orElseThrow(()->new IllegalArgumentException("Ventaq no encontrada"));
            empleado.ventas.remove(venta);
        });


    }
}
