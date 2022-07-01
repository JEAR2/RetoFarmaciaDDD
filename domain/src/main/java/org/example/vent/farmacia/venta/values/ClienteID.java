package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.Identity;
import org.example.vent.farmacia.empleado.values.EstudioID;

public class ClienteID extends Identity {
    public ClienteID(){

    }

    private ClienteID(String id){
        super(id);
    }

    public static ClienteID of(String id){
        return new ClienteID(id);
    }
}
