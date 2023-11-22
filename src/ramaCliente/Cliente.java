package ramaCliente;

import java.util.List;

import ramaAuxiliar.Mail;
import ramaCliente.Orden.Orden;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;

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
	public void recibirMail(Mail mail) {
		this.buzon.add(mail);
	}
	
	public abstract Chofer informarChoferDesignado(); 
	public abstract Camion informarCamionDesignado(); 
	
	
	//Getter and setter
	public Orden getOrden() {
		return this.orden;
	}
	
	
	
	
}
