package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class EstudioID extends Identity {

    public EstudioID(){

    }

    private EstudioID(String id){
        super(id);
    }

    public static EstudioID of(String id){
        return new EstudioID(id);
    }
}
