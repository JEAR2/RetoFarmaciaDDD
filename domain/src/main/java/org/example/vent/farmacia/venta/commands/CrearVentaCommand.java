package org.example.vent.farmacia.venta.commands;

import co.com.sofka.domain.generic.Command;
import org.example.vent.farmacia.venta.values.ClienteID;
import org.example.vent.farmacia.venta.values.Nombre;
import org.example.vent.farmacia.venta.values.VentaID;

public class CrearVentaCommand extends Command {
    private final VentaID ventaI;
    private final ClienteID clienteID;
    private final Nombre nombre;

    public CrearVentaCommand(VentaID ventaI, ClienteID clienteID, Nombre nombre) {
        this.ventaI = ventaI;
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public VentaID getVentaI() {
        return ventaI;
    }
}
