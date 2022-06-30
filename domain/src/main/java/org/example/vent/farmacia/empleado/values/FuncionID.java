package org.example.vent.farmacia.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class FuncionID extends Identity {

    public FuncionID(){

    }

    private FuncionID(String id){
        super(id);
    }

    public static FuncionID of(String id){
        return new FuncionID(id);
    }
}
