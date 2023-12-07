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
	
	public void setPosicion(Coordenada posicion) {
		this.posicion = posicion;
	}

	
	public void recibirPreaviso(Buque buque) {}

	
	public void recibirPostAviso(Buque buque) {}


	public void depart(Buque buque) {}
	
	
}
