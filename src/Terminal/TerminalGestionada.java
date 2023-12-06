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
import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;


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
		
		/*
		 * (Se debe generar la orden de importacion en dos fases 1-instanciar 2-setear fechaLlegada, camion y chofer)
			1) Enviar MailFecha al consignee indicando fecha y hora de llegada de su carga. (Margen de retiro de carga: 24 hs con respecto a dicha fecha y hora)
			2) Al recibir el MailFecha el consignee informa a la terminal el camion y chofer que retirará su carga.

		 */
		
		
		
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
		// devuelve la proxima fecha de partida de un buque desde TerminalGestionada hasta destino.
		// navieras..flota..buque...viajeDelBuque...destino.
		
		/*return this.navieras.stream().map(naviera -> naviera.getFlota()) //Stream<List<Buque>>
							  .flatMap(List::stream)  			  // Aplanar el Stream<List<Buque>> a un Stream<Buque>
							  .map(buque -> buque.getViaje())     //Stream<viaje>
							  .filter(viaje -> viaje.getDestino().equals(destino)) //Stream de viajes cuyo destino == destino
							  .filter(viaje -> viaje.getFechaDeSalida()) //Stream de fechas de salida de cada viaje
							  .findFirst();
		*/
		
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
