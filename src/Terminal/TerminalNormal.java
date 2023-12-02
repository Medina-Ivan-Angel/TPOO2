package Terminal;

import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Coordenada;

public class TerminalNormal {

	//Atributos
	private Coordenada posicion;
	
	//Constructor
	public TerminalNormal(Coordenada posicion) {
		this.posicion = posicion;
	}
	
	
	//Metodos
	
	
	
	//Getters and Setters
	public Coordenada getPosicion() {
		return this.posicion;
	}

	/* TODO: El buque llama a este método, al enviar un preaviso y 
	 esta terminal informa a todos los consignees con un MailAviso  */
	public void recibirPreaviso(Buque buque) {}

	/* TODO: El buque llama a este método, al enviar un postaviso y 
	 esta terminal informa a todos los shippers con un MailAviso  */
	public void recibirPostAviso(Buque buque) {}
	
	
}
