// Package de la clase.
package ramaDeposito;

import java.time.Duration;
//Imports.
import java.util.ArrayList;
import java.util.List;
import ramaCliente.Orden.Orden;
import ramaCliente.Orden.OrdenExportacion;

public class Deposito {

	// Atributos.
	private List<Orden> ordenesActivas = new ArrayList<Orden>();
	private List<Container> containers = new ArrayList<Container>();
	
	
	// Constructor.
	public Deposito(List<Orden> ordenes, List<Container> carga) {
		this.ordenesActivas = ordenes;
		this.containers = carga;
	}
	
	
	// Metodos.
		// Para agregar ordenes y containers a las listas.
	public void addOrden(Orden orden) {
		this.ordenesActivas.add(orden);
	}
	
	public void addContainer(Container container) {
		this.containers.add(container);
	}
	
	
		// Se encarga del accionar cuando un camion
		// de un Shipper (es decir, un camion con carga
		// a exportar) llega al deposito.
	public void registrarCargaEnElPuerto(Camion camion) {
		this.clienteInformóChoferYCamion(camion);
		this.camionLlegaConElContainerALaHoraCorrecta(camion);
		this.containers.add(camion.descargar());
	}

	
		/*
		 * Metodos auxiliares para corroborrar 
		 * que el Camion llega en Hora.
		 */
	private void camionLlegaConElContainerALaHoraCorrecta(Camion camion)  throws Exception  {
		if(!this.esLaMismaHoraDeLlegada(camion)) {
			throw new Exception("No llego a la hora acordada.");
		}
		
	}

	private boolean esLaMismaHoraDeLlegada(Camion camion) {
		Duration duracion = Duration.between(null, null);
		
		return(
				true
		);
	}

	
		/*
		 * Metodos auxiliares para corroborrar que 
		 * sea el Camion y Chofer correctos. 
		*/
	private void clienteInformóChoferYCamion(Camion camion) throws Exception  {
		if(!this.esChoferCorrecto(camion) || !this.esCamionCorrecto(camion)) {
			throw new Exception("No esta autorizado.");
		}
	}

	private boolean esCamionCorrecto(Camion camion) {
		return(ordenesActivas.stream().anyMatch(
				orden -> orden.getCamion().equals(camion)
				));
	}

	private boolean esChoferCorrecto(Camion camion) {
		return(ordenesActivas.stream().anyMatch(
				orden -> orden.getChofer().equals(
						camion.getConductor())
				));
	}
	
	
		// Se encarga del accionar cuando un camion
		// de un Consignee (es decir, un camion sin carga
		// que viene a retirar una) llega al deposito.
	public void cargarCamion(Camion camion) {
		this.clienteInformóChoferYCamion(camion);
		camion.cargar(this.containerCorrespondiente(camion));
	}


	private Container containerCorrespondiente(Camion camion) {
	    Container containerACargar = null;
	    for (Orden orden : this.ordenesActivas) {
	        if (orden.getCamion().equals(camion)) {
	            containerACargar = orden.getCarga();
	            break;
	        }
	    }
	    return containerACargar;
	}
	
}
