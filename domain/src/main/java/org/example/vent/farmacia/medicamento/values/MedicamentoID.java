package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.Identity;

public class MedicamentoID extends Identity {
    public MedicamentoID(){

    }

    private MedicamentoID(String id){
        super(id);
    }

    public static MedicamentoID of(String id){
        return new MedicamentoID(id);
    }
}
