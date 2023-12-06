package ramaCliente;

import Terminal.TerminalNormal;
import ramaCliente.Orden.OrdenExportacion;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;

public class Shipper extends Cliente {

	/*
	 * El Shipper es el Exportador, su atributo heredado "Orden"
	 * siempre es una OrdenExportacion.
	 * El Shipper es quien ENVIA la carga fuera de la terminal gestionada.
	 */
	
	
	//Atributos
	//TODO: Implementar Terminal / terminal portuaria ¿No viene ya dado por la orden de exportacion?
	//OBS: Puede que deba conocerlo de antemano para elegir la mejor ruta/viaje en la terminal
	//private TerminalNormal destino; 
	
	
	//CONSTRUCTOR

	//Metodos
	
	@Override
	public Chofer informarChoferDesignado() {
		return this.getOrden().getChofer(); // El chofer designado ya esta definido en la ordenExportacion
	}

	@Override
	public Camion informarCamionDesignado() {
		return this.getOrden().getCamion(); // El camion designado ya esta definido en la ordenExportacion
	}
	
	
	//Getters and setters

	/*
	//TODO: Hace falta este metodo? La orden de Exportacion ya lo tiene.
	public TerminalNormal getDestino() {
		return this.destino;
	}*/

}
