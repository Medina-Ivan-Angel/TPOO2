package Terminal;

import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Coordenada;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Naviera;
import ramaNavieraCircuitos.Viaje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import ramaAuxiliar.Mail;
import ramaAuxiliar.MailFecha;

import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;
import ramaCliente.Orden.OrdenImportacion;
import ramaDeposito.Container;
import ramaDeposito.Deposito;
import ramaDeposito.EmpresaDeTransporte;

public class TerminalGestionada extends TerminalNormal{

	//Atributos
	private List<Cliente> clientes = new ArrayList<Cliente>(); 					// Shippers y Consignees
	private List<Naviera> navieras = new ArrayList<Naviera>(); 					// Empresas navieras
	private List<Circuito> circuitosRelacionados = new ArrayList<Circuito>();	// Circuitos que incluyen esta terminal (generar)
	// private List<EmpresaDeTransporte> empresasDeTransporte = new ArrayList<EmpresaDeTransporte>(); //Empresas de transporte
		
	
	private Deposito deposito; // Deposito donde se realiza la carga/descarga
	// TODO: Añadir motor de busqueda
	
	//Constructor
	public TerminalGestionada(Coordenada posicion, 
							  List<Naviera> navieras,
							  List<Cliente> clientes,
							  Deposito deposito) {

		super(posicion); 		  //Coordenada de ubicacion de la terminal
		
		this.navieras 			  = navieras;
		this.clientes 			  = clientes;
		this.deposito			  = deposito; 
		
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
		/*
		 * El consignee se debe instanciar con una orden de importacion predefinida
		 * porque se asume que todo el tramite previo de importacion ya se realizo
		 * previamente por lo que ya tiene su propia orden de importacion.
		 */
		
		//Generamos el mail con la fecha de llegada del buque del Consignee
		MailFecha mailFecha = new MailFecha(consignee.getOrden().getfechaLlegadaDeCarga());
		
		//Informamos al consignee sobre la llegada del buque
		this.enviarMailA(consignee, mailFecha);
		
		this.deposito.addOrdenImportacion(consignee.getOrden()); //Se informo del chofer y el camion en este paso
		
	}
	
	public void enviarMailA(Cliente cliente, Mail mail) {
		// Se asume que siempre se asignara el mail correcto con el cliente correcto.
		
		cliente.recibirMail(mail); //Enviamos el mail al cliente correspondiente
	}
	
	
	public Viaje buscarMejorRutaParaShipper(Shipper shipper) {
		return null;
	}
	
	
	public LocalDateTime proximaFechaDePartidaA(TerminalNormal destino) {
		// devuelve la proxima fecha de partida de un buque desde TerminalGestionada hasta destino.

		return this.navieras.stream()
	            .map(naviera -> naviera.getFlota())    // Stream<List<Buque>>
	            .flatMap(List::stream)                  // Aplanar el Stream<List<Buque>> a un Stream<Buque>
	            .map(Buque::getViaje)                   // Stream<Viaje>
	            .filter(viaje -> viaje.getTerminalDestino().equals(destino))  // Stream de viajes cuyo destino == destino
	            .map(Viaje::getFechaDeSalida)          // Stream de fechas de salida de cada viaje
	            .filter(Objects::nonNull)              // Filtrar las fechas no nulas
	            .min(LocalDateTime::compareTo)         // Encontrar la fecha mínima
	            .orElse(null);                         // Devolver null si no se encuentra ninguna fecha
		
		
		
	}
	

	
	//Getters and Setters

	
	
}
