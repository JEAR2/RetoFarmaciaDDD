package org.example.vent.farmacia.venta.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaID extends Identity {
    public FacturaID(){

    }

    private FacturaID(String id){
        super(id);
    }

    public static FacturaID of(String id){
        return new FacturaID(id);
    }
}
