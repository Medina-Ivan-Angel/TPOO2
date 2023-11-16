package ramaCliente;

public class Shipper extends Cliente {

	/*
	 * El Shipper es el Exportador, su atributo heredado "Orden"
	 * siempre es una OrdenExportacion.
	 * El Shipper es quien ENVIA la carga fuera de la terminal gestionada.
	 */
	
	
	//Atributos
	private TerminalPortuaria destino; //TODO: Implementar Terminal / terminal portuaria ¿No viene ya dado por la orden de exportacion?
	
	
	//CONSTRUCTOR
	public Shipper(OrdenExportacion ordenExportacion) {
		super(ordenExportacion);
	}

	//Metodos
	
	@Override
	public Chofer informarChoferDesignado() {
		// TODO: Implementar. ¿Obtiene el chofer de la orden de exportacion?
		//orden.getChofer()
		return null;
	}

	@Override
	public Camion informarCamionDesignado() {
		// TODO: Implementar. ¿Obtiene el camion de la orden de exportacion?
		//orden.getCamion();
		return null;
	}
	
	
	//Getters and setters

	//TODO: Hace falta este metodo? La orden de Exportacion ya lo tiene.
	public TerminalPortuaria getDestino() {
		return this.destino;
	}

}
