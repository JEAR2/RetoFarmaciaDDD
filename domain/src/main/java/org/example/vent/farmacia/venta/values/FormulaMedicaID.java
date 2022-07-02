package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.Identity;

public class FormulaMedicaID extends Identity {
    public FormulaMedicaID(){

    }

    private FormulaMedicaID(String id){
        super(id);
    }

    public static FormulaMedicaID of(String id){
        return new FormulaMedicaID(id);
    }
}
