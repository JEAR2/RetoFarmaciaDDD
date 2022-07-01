package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.Identity;

public class LaboratorioID extends Identity {
    public LaboratorioID(){

    }

    private LaboratorioID(String id){
        super(id);
    }

    public static LaboratorioID of(String id){
        return new LaboratorioID(id);
    }
}
