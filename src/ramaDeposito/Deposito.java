// Package de la clase.
package ramaDeposito;

// Imports de Java.
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
// Import de clases del Tp.
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Orden.OrdenImportacion;
import ramaCliente.Servicios.AlmacenamientoExcedente;

/*
 * REFERENCIAS:
 * 				1. Los comentarios de parrafo se usan para indicar a 
 * 				   mas de un metodo, es decir, que cuando hay un 
 * 				   comentario de parrafo lo que diga es relacionado
 * 				   a todos los metodos que tenga abajo mientras la 
 * 				   distancia entre ellos no sea de mas de un espacio.
 * 				2. Los comentarios de linea solo afectan a los metodos/
 * 				   clases/variables que tengan que tengan directamente
 * 				   abajo o mas cerca (ej. al lado como en costoPorDia). 
*/

public class Deposito {

	/* Atributos. */
	private List<OrdenExportacion> ordenesDeExportacion = new ArrayList<OrdenExportacion>();
	private List<OrdenImportacion> ordenesDeImportacion = new ArrayList<OrdenImportacion>();
	private List<Container> containers = new ArrayList<Container>();
	private double costoPorDia; // Es el costo que le tengo que cobrar a un consignee por almacenamiento excedente.
	
	// Constructor.
	public Deposito(List<OrdenImportacion> ordenesDeImportacion, List<OrdenExportacion> ordenesDeExportacion , List<Container> carga, double costo) {
		this.ordenesDeImportacion = ordenesDeImportacion;
		this.ordenesDeExportacion = ordenesDeExportacion;
		this.containers = carga;
		this.costoPorDia = costo;
	}
	
	
	/* Metodos. */
		/* Para agregar ordenes y containers a las listas.*/
	public void addOrdenImportacion(OrdenImportacion orden) {
		this.ordenesDeImportacion.add(orden);
	}
	
	public void addOrdenExportacion(OrdenExportacion orden) {
		this.ordenesDeExportacion.add(orden);
	}
	
	public void addContainer(Container container) {
		this.containers.add(container);
	}
	
	
		// Se encarga del accionar cuando un camion
		// de un Shipper (es decir, un camion con carga
		// a exportar) llega al deposito.
	public void registrarCargaEnElPuerto(Camion camion) throws Exception {
		this.clienteInformóChoferYCamion(camion); // --> Validacion.
		this.camionLlegaConElContainerALaHoraCorrecta(camion); // --> Validacion.
		this.containers.add(camion.descargar()); // --> Accion. (Si es que las validaciones no fallan).
	}
	
	
		// Se encarga del accionar cuando un camion
	 	// de un Consignee (es decir, un camion sin carga
	 	// que viene a retirar una) llega al deposito.
	public void cargarCamion(Camion camion) throws Exception {
		this.clienteInformóChoferYCamion(camion); // --> Validacion.
		this.camionLlegoDentroDeLasHorasAsignadas(camion); // --> Validacion.
		camion.cargar(this.containerCorrespondiente(camion)); // --> Accion. (Si es que las validaciones no fallan).
	}

	
		/* Metodos auxiliares para corroborrar 
		 * que el Camion llega en Hora.
		*/
			// Usa una validacion para ver si tiene que tirar un error
			// porque la carga del shipper llego tarde o no.
	private void camionLlegaConElContainerALaHoraCorrecta(Camion camion)  throws Exception  {
		if(!this.esLaMismaHoraDeLlegada(camion)) { // --> Validacion.
			throw new Exception("No llego a la hora acordada."); // --> Error. (Si da mal la validacion.)
		}
		
	}

			// Hace un recorrido x las ordenes de exportacion para ver
			// si llego dentro del rango horario (no mas de 3 hs)
			// el camion. 
	private boolean esLaMismaHoraDeLlegada(Camion camion) {
		LocalDateTime horaDeLlegadaCamion = camion.getHraDeLlegada();
	    for (OrdenExportacion orden : this.ordenesDeExportacion) {
	        if (orden.getCamion().equals(camion)) {
	            LocalDateTime horaDeLlegadaOrden = orden.getFechaSalidaDeCarga();
	            long diferenciaEnHoras = ChronoUnit.HOURS.between(horaDeLlegadaCamion, horaDeLlegadaOrden);
	            if (Math.abs(diferenciaEnHoras) <= 3) {
	                return(true);
	            }
	        }
	    }
	    return(false);
	}

	
		/*
		 * Metodos auxiliares para corroborrar que 
		 * sea el Camion y Chofer correctos. 
		*/
			// Usa una validacion para ver si es el chofer 
			// y camion correcto, en caso contrario tira 
			// un error.
	private void clienteInformóChoferYCamion(Camion camion) throws Exception  {
		if(!this.esChoferCorrecto(camion) || !this.esCamionCorrecto(camion)) { // ---> Validaciones.
			throw new Exception("No esta autorizado."); // ---> Error. (Si falla la validacion.)
		}
	}

			// Usa un Stream para mirar si en las ordenes de importacion
			// o Exportacion hay alguna que cumpla con el camion dado.
	private boolean esCamionCorrecto(Camion camion) {
		return(
				ordenesDeExportacion.stream().anyMatch(
				orden -> orden.getCamion().equals(camion)) 
				|| 
				ordenesDeImportacion.stream().anyMatch(
				orden -> orden.getCamion().equals(camion))
		);
	}

			// Usa un Stream para mirar si en las ordenes de importacion
			// o Exportacion hay alguna que cumpla con el chofer dado.
 	private boolean esChoferCorrecto(Camion camion) {
		return(
				ordenesDeExportacion.stream().anyMatch(
				orden -> orden.getChofer().equals(camion.getConductor()))
				|| 
				ordenesDeImportacion.stream().anyMatch(
				orden -> orden.getChofer().equals(camion.getConductor()))
		);
	}
	

 		// Metodo para ver si el camion del consignee llego dentro
 		// de las 24 hs pautadas, en caso contrario le cobra el extra.
	private void camionLlegoDentroDeLasHorasAsignadas(Camion camion) {
		if(!this.noPasaron24Hrs(camion)) { // ---> Validacion. 
			for (OrdenImportacion orden : this.ordenesDeImportacion) { // Bucle for para buscar entre las ordenes la que corresponda y poder sacarle los datos necesarios.
				if (orden.getCamion().equals(camion)) {
					orden.addServicio(
						new AlmacenamientoExcedente(
							this.costoPorDia, 
							this.calcularEstadia(camion)));
	            }
			}
		}
	}


		// Calcula el precio extra por pasar las 24hs en deposito.
	private double calcularEstadia(Camion camion) {
		return(this.calcularCantDeHoras(camion) * this.costoPorDia);
	}

	
		// Calcula la cantidad de horas que estuvo el container
		// en el deposito con respecto a su hora de llegada (
		// que esta en la orden).
	private double calcularCantDeHoras(Camion camion) {
		long diferenciaEnHoras = 0;
		LocalDateTime horaDeLlegadaCamion = camion.getHraDeLlegada();
		LocalDateTime horaDeLlegadaOrden;
		for (OrdenImportacion orden : this.ordenesDeImportacion) {
			if (orden.getCamion().equals(camion)) {
				horaDeLlegadaOrden = orden.getfechaLlegadaDeCarga();
				diferenciaEnHoras = ChronoUnit.HOURS.between(
						horaDeLlegadaCamion, horaDeLlegadaOrden);
			}
    	}
		return(Math.abs(diferenciaEnHoras));
	}
	
		
		// Validacion que mira que la cantidad de horas que paso
		// el container en el deposito desde que llego no sean
		// mayores a 24.
	private boolean noPasaron24Hrs(Camion camion) {
		if (this.calcularCantDeHoras(camion) <= 24) {
			return true;
		} else {
			return false;
		}
	    
	}

		// Hace un recorrido por las orden de importacion para sacar
		// de la lista de containers el que le corresponde y asi
		// devolverlo.
	private Container containerCorrespondiente(Camion camion) {
	    Container containerACargar = null;
	    for (OrdenImportacion orden : this.ordenesDeImportacion) {
	        if (orden.getCamion().equals(camion)) {
	            containerACargar = orden.getCarga();
	            break;
	        }
	    }
	    return containerACargar;
	}
	
}
