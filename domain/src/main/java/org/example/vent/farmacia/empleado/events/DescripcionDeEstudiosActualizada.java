package org.example.vent.farmacia.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.vent.farmacia.empleado.values.DescripcionEstudios;
import org.example.vent.farmacia.empleado.values.EstudioID;

public class DescripcionDeEstudiosActualizada extends DomainEvent {
    private final EstudioID estudioID;
    private final DescripcionEstudios descripcionEstudios;

    public DescripcionDeEstudiosActualizada(EstudioID estudioID, DescripcionEstudios descripcionEstudios) {
        super("org.example.vent.farmacia.DescripcionDeEstudiosActualizada");
        this.estudioID = estudioID;
        this.descripcionEstudios = descripcionEstudios;
    }

    public DescripcionEstudios descripcionEstudios() {
        return descripcionEstudios;
    }

    public EstudioID estudioID() {
        return estudioID;
    }

}
