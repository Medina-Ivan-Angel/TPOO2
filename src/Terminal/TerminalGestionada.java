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
import java.util.stream.Collectors;

import ramaAuxiliar.FacturaConsignee;
import ramaAuxiliar.FacturaShipper;
import ramaAuxiliar.Mail;
import ramaAuxiliar.MailAviso;
import ramaAuxiliar.MailFactura;
import ramaAuxiliar.MailFecha;

import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Orden.OrdenImportacion;
import ramaCliente.Servicios.Pesado;
import ramaCliente.Servicios.Servicio;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;
import ramaDeposito.Deposito;
import ramaDeposito.EmpresaDeTransporte;

public class TerminalGestionada extends TerminalNormal{

	//Atributos
	private List<Cliente> clientes = new ArrayList<Cliente>(); 					// Shippers y Consignees
	private List<Naviera> navieras = new ArrayList<Naviera>(); 					// Empresas navieras
	private List<Circuito> circuitosRelacionados = new ArrayList<Circuito>();	// Circuitos que incluyen esta terminal (generar)
	private MotorBusqueda busquedas;
	private double costoPorPesado;	//Costo fijo de pesado
	
	private Plan mejorPlan;	// Define que criterio utilizar para encontrar el mejor circuito
	
	private Deposito deposito; // Deposito donde se realiza la carga/descarga

	//Constructor
	public TerminalGestionada(Coordenada posicion, 
							  List<Naviera> navieras,
							  List<Cliente> clientes,
							  Deposito deposito,
							  double costo) {

		super(posicion); 		  //Coordenada de ubicacion de la terminal
		
		this.navieras 			  = navieras;
		this.clientes 			  = clientes;
		this.deposito			  = deposito; 
		this.costoPorPesado       = costo;
	}
	
	
	
	//Metodos
	public Circuito mejorCircuito(TerminalNormal origen, TerminalNormal destino) {
		
		//Obtenemos una lista de circuitos
		List<Circuito> circuitos = this.navieras.stream()
		        					   .flatMap(naviera -> naviera.getCircuitosMaritimos().stream()) //Aplanamos las listas en un solo flujo continuo de circuitos.
		        					   .collect(Collectors.toList()); //Convertir en lista
		
		
		// Segun el plan que hayamos seteado obtenemos distintos resultados de Circuito.
		return this.mejorPlan.operacion(origen, destino, circuitos);
	}
	
	public void exportacion(Shipper shipper, LocalDateTime fechaS, 
			LocalDateTime fechaI, Container cn, 
			Camion cm, Chofer ch, EmpresaDeTransporte e,
			Buque b, List<Servicio> s) {
		
		Viaje mejorRuta = this.busquedas.mejorRuta();   // Se elije la ruta.
		
		OrdenExportacion orden = new OrdenExportacion(
				shipper.getDestino(), 
				fechaS, fechaI, shipper, cn, cm, ch, e, b); // Se crea la orden
		
		/*
		 * Se agrega el servicio de pesado que siempre esta en la
		 * orden y luego por un bucle for se agrega a la orden los
		 * servicios que el cliente le quiera contratar. 
		*/
		orden.addServicio(new Pesado(this.costoPorPesado, cn));
		for(Servicio servicio : s) {
			orden.addServicio(servicio);
		}
		
		shipper.setOrden(orden);  // Se asigna la orden.
		
		
		// Se registra el container y la orden 
		// en la terminal (deposito).
		this.deposito.addContainer(cn);
		this.deposito.addOrdenExportacion(orden);
	}
	
	public void importacion(Consignee consignee) {
		/*
		 * El consignee se debe instanciar con una orden 
		 * de importacion predefinida porque se asume que
		 * todo el tramite previo de importacion ya se realizo
		 * previamente por lo que ya tiene su propia orden 
		 * de importacion.
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
	
	
	@Override
	public void recibirPreaviso(Buque buque) {
		
		//Mail para enviar al consignee correspondiente.
		MailAviso mailAviso = new MailAviso("Su carga esta llegando");
		
		//Buscamos los consignees involucrados y les enviamos el mail correspondiente.
	    this.listaDeConsignees().stream()
	    						.filter(consignee -> consignee.getOrden().getBuque().equals(buque)) //Stream de consignees que tengan al buque
								.forEach(consignee -> consignee.recibirMail(mailAviso));

		
	}
	
	
	@Override
	public void recibirPostAviso(Buque buque) {
		
		/*El buque zarpa - Fin exportacion- (Fase Departing) 
		 * Al alejarse mas de 1km envia un postAviso a la terminal 
		 * y la terminal un MailAviso a los shippers avisando que 
		 * su carga ya ha salido de la terminal
		 */
		
		//Mail para enviar al shipper correspondiente.
		MailAviso mailAviso = new MailAviso("Su carga ha salido de la terminal");
	
		//Buscamos los shippers involucrados y les enviamos el mail correspondiente.
		this.listaDeShippers().stream()
	    					  .filter(shipper -> shipper.getOrden().getBuque().equals(buque)) //Stream de shippers que tengan al buque
							  .forEach(shipper -> shipper.recibirMail(mailAviso));
		
	}
	
	public List<Shipper> listaDeShippers(){
		//Obtenemos los shippers.	
		return clientes.stream()
				       .filter(Shipper.class::isInstance) // filtramos las instancias de Shipper
				       .map(Shipper.class::cast) // Convertir a List<Shipper> la lista de clientes
				       .collect(Collectors.toList());	//Transformamos en lista
		
		
	}
	
	public List<Consignee> listaDeConsignees(){
		
		return clientes.stream()
				.filter(Consignee.class::isInstance) // filtramos las instancias de consignee
			    .map(Consignee.class::cast) // Convertir a List<Consignee> la lista de clientes
			    .collect(Collectors.toList());	//Transformamos en lista
		
	}
	
	
	
	public void enviarFacturasALosClientes(Buque buque) {
		
		//Buscamos los shippers involucrados y les enviamos el mail con la factura correspondiente.
		this.listaDeShippers().stream()
			    			  .filter(shipper -> shipper.getOrden().getBuque().equals(buque)) //Stream de shippers que tengan al buque
							  .forEach(shipper -> shipper.recibirMail(new MailFactura(new FacturaShipper(LocalDateTime.now(), shipper)))); //Creamos el mail factura y la factura dentro del mail con la fecha actual y la enviamos al shipper
		
		//Buscamos los consignees involucrados y les enviamos el mail correspondiente.
	    this.listaDeConsignees().stream()
	    						.filter(consignee -> consignee.getOrden().getBuque().equals(buque)) //Stream de consignees que tengan al buque
								.forEach(consignee -> consignee.recibirMail(new MailFactura(new FacturaConsignee(LocalDateTime.now(), consignee)))); // Creamos el mail factura y la factura dentro del mail con la fecha actual y la enviamos al consignee
		
	    
	}
	
	//Esta es una señal que se envia al buque para que inicie la carga/descarga en puerto
	public void iniciarCargaDescarga(Buque buque) {
		buque.iniciarCargaYDescarga();
	}

	//Se envia la señal "depart" al buque al finalizar la carga/descarga para que zarpe
	public void depart(Buque buque) {
		buque.depart();
	}
	
	//Getters and Setters
	
	public List<Naviera> getNavieras(){
		return this.navieras;
	}

	public void setMejorPlan(Plan plan) {
		this.mejorPlan = plan;
	}
	
	
}
