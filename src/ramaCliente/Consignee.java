package ramaCliente;

import java.time.LocalDateTime;

import ramaAuxiliar.MailFecha;
import ramaCliente.Orden.OrdenImportacion;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;

public class Consignee extends Cliente {

	/*
	 * El Consignee es el Importador su atributo heredado "orden" es
	 * siempre una ordenImportacion.
	 * El Consignee es quien TRAE carga hacia la terminal gestionada.
	 * 
	 * La fecha de llegada, el camion y el chofer
	 * se setean en la terminal durante la operacion de importacion
	 */
	
	//Atributos
	//TODO: Hace falta esto? La orden de importacion ya lo tiene.
	//OBS: Puede que deba conocerlo de antemano para elegir la mejor ruta/viaje en la terminal
	private TerminalPortuaria origen; 
	
	
	
	//CONSTRUCTOR
	public Consignee(OrdenImportacion ordenImportacion) {
		 super(ordenImportacion);
	}
	
	//Metodos
	@Override
	public Chofer informarChoferDesignado() {
		// PRECONDICION: No llamar este metodo antes de haber seteado 
		// el valor Chofer en la ordeImportacion correspondiente
		
		return this.getOrden().getChofer();
	}

	@Override
	public Camion informarCamionDesignado() {
		// PRECONDICION: No llamar este metodo antes de haber seteado 
		// el valor Camion en la ordenImportacion correspondiente
		
		return this.getOrden().getCamion();
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
