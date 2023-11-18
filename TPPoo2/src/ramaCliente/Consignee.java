package ramaCliente;

import java.time.LocalDateTime;

public class Consignee extends Cliente {

	/*
	 * El Consignee es el Importador su atributo heredado "orden" es
	 * siempre una ordenImportacion.
	 * El Consignee es quien TRAE carga hacia la terminal gestionada
	 */
	
	//Atributos
	private TerminalPortuaria origen; //TODO: Hace falta esto? La orden de importacion ya lo tiene
	
	
	
	//CONSTRUCTOR
	public Consignee(OrdenImportacion ordenImportacion) {
		 super(ordenImportacion);
	}
	
	//Metodos
	@Override
	public Chofer informarChoferDesignado() {
		// TODO: Implementar. ¿Obtiene el chofer de la orden de importacion?
		// orden.getChofer()
		return null;
	}

	@Override
	public Camion informarCamionDesignado() {
		// TODO: Implementar. ¿Obtiene el camion de la orden de importacion?
		//orden.getCamion();
		return null;
	}
	
	//Getters and Setters
	
	//TODO: Es esto necesario? La orden de importacion ya lo tiene.
	public TerminalPortuaria getOrigen() {
		return this.origen;
	}
	
	public LocalDateTime getFechaYHoraDeLlegada(){
		
		return this.buzon.stream()									 // Buzon de la superclase Cliente
                		 .filter(mail -> mail instanceof MailFecha)  // obtenemos los mails que sean MailFecha 
                		 .map(mail -> ((MailFecha) mail).getFecha()) // obtenemos el atributo fecha de dicho mail
                		 .findFirst() 								 // Nos quedamos con la primera fecha encontrada (teoricamente deberia haber solo 1)
                		 .orElse(null); 							 // Devolvemos null si no hay mailFecha (Asumiremos que siempre hay?)
	}
	
}
