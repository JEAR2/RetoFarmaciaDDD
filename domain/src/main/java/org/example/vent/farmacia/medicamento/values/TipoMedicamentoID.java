package org.example.vent.farmacia.medicamento.values;

import co.com.sofka.domain.generic.Identity;
import org.example.vent.farmacia.empleado.values.EmpleadoID;

public class TipoMedicamentoID extends Identity {
    public TipoMedicamentoID(){

    }

    private TipoMedicamentoID(String id){
        super(id);
    }

    public static TipoMedicamentoID of(String id){
        return new TipoMedicamentoID(id);
    }
}
