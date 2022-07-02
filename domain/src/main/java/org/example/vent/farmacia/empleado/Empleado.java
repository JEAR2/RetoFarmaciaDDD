package org.example.vent.farmacia.empleado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.entities.Estudio;
import org.example.vent.farmacia.empleado.entities.Funcion;
import org.example.vent.farmacia.empleado.entities.Rol;
import org.example.vent.farmacia.empleado.events.*;
import org.example.vent.farmacia.empleado.values.*;
import org.example.vent.farmacia.venta.values.VentaID;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Empleado extends AggregateEvent<EmpleadoID> {
    protected Nombre nombre;
    protected Celular celular;
    protected Correo correo;

    protected Rol rol;
    protected RolID rolID;

    protected Descripcion descripcion;
    protected Set<VentaID> ventas;
    protected Set<Funcion> funciones;
    protected Set<Estudio> estudios;

    public Empleado(EmpleadoID entityId, Nombre nombre, Celular celular, Correo correo,RolID rolID, Descripcion descripcion) {
        super(entityId);
        appendChange(new EmpleadoCreado(nombre,celular,correo,rolID,descripcion)).apply();

    }

    private Empleado(EmpleadoID empleadoID){
        super(empleadoID);
        subscribe(new EmpleadoEventChange(this));
    }

    public static Empleado from(EmpleadoID empleadoID, List<DomainEvent> events){
        var empleado = new Empleado(empleadoID);
        events.forEach(empleado::applyEvent);
        return empleado;
    }


    //Comportamientos
    public void agregarFuncion(FuncionID entityId, Descripcion descripcion){
        appendChange(new FuncionAgregada(entityId,descripcion)).apply();
    }

    public void crearFuncion(FuncionID funcionID, Descripcion descripcion){
        appendChange(new FuncionCreada(funcionID,descripcion)).apply();
    }

    public void eliminarFuncion(FuncionID funcionID){
        appendChange(new FuncionEliminada(funcionID)).apply();
    }

    public void agregarVenta(VentaID ventaID){
        appendChange(new VentaAgregada(ventaID)).apply();
    }

    public void eliminarVenta(VentaID ventaID){
        appendChange(new VentaEliminada(ventaID)).apply();
    }

    public void agregarEstudio(EstudioID estudioID, DescripcionEstudios descripcionEstudios){
        appendChange(new EstudioAgregado(estudioID,descripcionEstudios)).apply();
    }

    public void cambiarCelular(EmpleadoID empleadoID, Celular celular){
        appendChange(new CelularEmpleadoCambiado(empleadoID,celular)).apply();
    }

    /*
    public void actualizarDetalleDescripcionDeFuncion(FuncionID funcionID,Nombre nombre, Descripcion descripcion){
        appendChange(new DetalleDeDescripcionDeFuncionActualizada(funcionID,descripcion)).apply();
    }
    */
    public void actualizarDetalleDescripcionDeFuncion(FuncionID funcionID,String descripcion){
        appendChange(new DetalleDescripcionDeFuncionActualizada(funcionID,descripcion)).apply();
    }

    public void actualizarDescripcionDeEstudios(EstudioID estudioID,DescripcionEstudios descripcionEstudios){
        appendChange(new DescripcionDeEstudiosActualizada(estudioID,descripcionEstudios)).apply();
    }

    public void actualizarDescripcionRol(RolID rolID,String descripcion){
        appendChange(new DescripcionDeRolActualizada(rolID,descripcion)).apply();
    }

    public Optional<Funcion> getFuncionPorID(FuncionID funcionID){
        return funciones().stream().filter(funcion -> funcion.identity().equals(funcionID)).findFirst();
    }

    public Optional<Estudio> getEstudioPorID(EstudioID estudioID){
        return estudios().stream().filter(estudio -> estudio.identity().equals(estudioID)).findFirst();
    }

    public Optional<VentaID> getVentaID(VentaID ventaID){
        return ventas().stream().filter(venta -> venta.equals(ventaID)).findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Correo correo() {
        return correo;
    }

    public Celular celular() {
        return celular;
    }


    public Set<Funcion> funciones() {
        return funciones;
    }

    public Set<Estudio> estudios() {
        return estudios;
    }

    public RolID rolID() {
        return rolID;
    }

    public Rol rol() {
        return rol;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<VentaID> ventas() {
        return ventas;
    }
}
