package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class RolID extends Identity {
    public RolID(){

    }

    private RolID(String id){
        super(id);
    }

    public static RolID of(String id){
        return new RolID(id);
    }
}
