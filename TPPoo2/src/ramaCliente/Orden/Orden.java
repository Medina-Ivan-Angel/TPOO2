package ramaCliente.Orden;

import java.util.ArrayList;
import java.util.List;

import ramaCliente.Cliente;
import ramaCliente.Servicios.Servicio;

public abstract class Orden {

	//Atributos
	List<Servicio> servicios = new ArrayList<Servicio>(); //Servicios aplicados a la carga
	private Cliente cliente;
	private Container carga;
	private Camion camion;
	private Chofer chofer;
	
	//Constructor
	public Orden(Cliente cliente,
				 Container carga,
				 Camion camion,
				 Chofer chofer) {
		
		this.cliente = cliente;
		this.carga	 = carga;
		this.camion  = camion;
		this.chofer  = chofer;
		
	}
	
	public Orden(Cliente cliente, Container carga) {
	
		this.cliente = cliente;
		this.carga	 = carga;
	
	}
	
	//Metodos	
	
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	//Getters and Setters
	public Camion getCamion() {
		return this.camion;
	}
	
	public Chofer getChofer() {
		return this.chofer;
	}
	
	public Container getCarga() {
		return this.carga;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
}
