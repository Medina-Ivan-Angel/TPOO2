package Terminal;

import ramaFasesDelBuque.Coordenada;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Naviera;
import ramaNavieraCircuitos.Viaje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ramaAuxiliar.Mail;
import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Deposito;
import ramaDeposito.EmpresaDeTransporte;

public class TerminalGestionada extends TerminalNormal{

	//Atributos
	private List<Cliente> clientes = new ArrayList<Cliente>(); 					// Shippers y Consignees
	private List<Naviera> navieras = new ArrayList<Naviera>(); 					// Empresas navieras
	private List<Circuito> circuitosRelacionados = new ArrayList<Circuito>();	// Circuitos que incluyen esta terminal (generar)
	private List<EmpresaDeTransporte> empresasDeTransporte = new ArrayList<EmpresaDeTransporte>(); //Empresas de transporte
	private List<Chofer> choferesAdmitidos = new ArrayList<Chofer>();			// Choferes con acceso a la terminal
	private List<Camion> camionesAdmitidos = new ArrayList<Camion>();			// Camiones con acceso a la terminal
	
	private Deposito deposito;													// Deposito donde se realiza la carga/descarga
	// TODO: Añadir motor de busqueda
	
	//Constructor
	public TerminalGestionada(Coordenada posicion, 
							  List<Naviera> navieras,
							  List<Chofer> choferesAdmitidos,
							  List<Camion> camionesAdmitidos,
							  List<EmpresaDeTransporte> empresasDeTransporte,
							  List<Cliente> clientes,
							  Deposito deposito) {

		super(posicion); 		  //Coordenada de ubicacion de la terminal
		
		this.navieras 			  = navieras;
		this.choferesAdmitidos 	  = choferesAdmitidos;
		this.camionesAdmitidos 	  = camionesAdmitidos;
		this.empresasDeTransporte = empresasDeTransporte;
		this.clientes 			  = clientes;
		this.deposito			  = deposito; // TODO: NECESITO las ordenes de imp/exp para crear el deposito.
		
	}
	
	
	
	//Metodos
	public Circuito mejorCircuito() {
		/*
		 *  ---POSIBLE STRATEGY---
 			El concepto de mejor debe poder ser seteado y cambiado dinamicamente en la TG.
   			Conceptos de "mejor" :  Menor tiempo total de recorrido entre origen y destino.
			  Menor precio total de recorrido entre origen y destino.
			  Menor cantidad de terminales intermedias entre origen y destino
		 */
		return null;
	}
	
	public void exportacion(Shipper shipper) {
		
		
	}
	
	public void importacion(Consignee consignee) {
		
		
		
	}
	
	public void enviarMailA(Cliente cliente, Mail mail) {
		// Se asume que siempre se asignara el mail correcto con el cliente correcto.
		
		cliente.recibirMail(mail); //Enviamos el mail al cliente correspondiente
	}
	
	
	public Viaje buscarMejorRutaParaShipper(Shipper shipper) {
		return null;
	}
	
	
	public LocalDateTime proximaFechaDePartidaA(TerminalNormal destino) {
		
		return null;
		
	}
	
	
	//Getters and Setters

	
	
}
