package org.example.vent.farmacia.empleado;

import org.example.vent.farmacia.empleado.values.EmpleadoID;
import org.example.vent.farmacia.medicamento.values.MedicamentoID;

public interface CelularServiceEmplado {
    void cambiarCelularEmpleado(EmpleadoID empleado, String body);
}
