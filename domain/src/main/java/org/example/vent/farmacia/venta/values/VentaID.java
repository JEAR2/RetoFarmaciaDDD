package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.Identity;
import org.example.vent.farmacia.empleado.values.EmpleadoID;

public class VentaID extends Identity {
    public VentaID(){

    }

    private VentaID(String id){
        super(id);
    }

    public static VentaID of(String id){
        return new VentaID(id);
    }
}
