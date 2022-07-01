package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.Identity;

public class ProveedorID extends Identity {
    public ProveedorID(){

    }

    private ProveedorID(String id){
        super(id);
    }

    public static ProveedorID of(String id){
        return new ProveedorID(id);
    }
}
