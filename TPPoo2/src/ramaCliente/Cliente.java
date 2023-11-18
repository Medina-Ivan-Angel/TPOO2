package ramaCliente;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {

	
	//Atributos
	private Orden orden; //Orden de importacion/exportacion del cliente.
	
	List<Mail> buzon = new ArrayList<Mail>(); //buzon donde se almacenan los mails 
	
	//CONSTRUCTOR 
	public Cliente(Orden orden) {
		this.orden = orden;
	}
	
	
	//Metodos
	public Orden getOrden() {
		return this.orden;
	}
	
	
	public abstract Chofer informarChoferDesignado(); //TODO: falta implementar chofer por Victor.
	
	public abstract Camion informarCamionDesignado(); //TODO: falta implementar camion por Victor.
	
	
	
	
	
	
}
