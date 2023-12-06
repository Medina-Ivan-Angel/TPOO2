package ramaCliente.Orden;

import java.util.ArrayList;
import java.util.List;

import ramaCliente.Cliente;
import ramaCliente.Servicios.Servicio;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;
import ramaDeposito.EmpresaDeTransporte;

public abstract class Orden {

	//Atributos
	private List<Servicio> servicios = new ArrayList<Servicio>(); //Servicios aplicados a la carga
	private Cliente cliente;
	private Container carga;
	private Camion camion;
	private Chofer chofer;
	private EmpresaDeTransporte empresaDeTransporte; //Empresa de transporte
	
	//Constructor
	public Orden(Cliente cliente,
				 Container carga,
				 Camion camion,
				 Chofer chofer,
				 EmpresaDeTransporte empresaDeTransporte) {
		
		this.cliente 			 = cliente;
		this.carga			     = carga;
		this.camion  			 = camion;
		this.chofer  			 = chofer;
		this.empresaDeTransporte = empresaDeTransporte;
	}
	
	public Orden(Cliente cliente, Container carga, EmpresaDeTransporte empresaDeTransporte) {
	
		this.cliente = cliente;
		this.carga	 = carga;
		this.empresaDeTransporte = empresaDeTransporte;
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
