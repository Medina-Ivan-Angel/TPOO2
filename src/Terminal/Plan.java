package Terminal;

import java.util.List;

import ramaNavieraCircuitos.Circuito;

public abstract class Plan {

	/*
	 * Esta clase define a los distintos planes o estrategias que se pueden utilizar
	 * para determinar cual es el mejor circuito en la Terminal Gestionada. Cumple
	 * el rol de compositor en el patron strategy. 
	 */
	
	//Este metodo es sobreescrito por las clases hijas
	public Circuito operacion(TerminalNormal origen, TerminalNormal destino, List<Circuito> circuitos) {
		return null;
	}
	
	
	
}
