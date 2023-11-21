// Package de la clase.
package ramaDeposito;

//Imports.
import java.util.ArrayList;
import java.util.List;
import ramaCliente.Orden.Orden;

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
		// Se encarga del accionar cuando un camion
		// de un Shipper (es decir, un camion con carga
		// a exportar) llega al deposito.
	public void registrarCargaEnElPuerto(Camion carga) {
		this.clienteInformóChoferYCamion(carga);
		this.camionLlegaConElContainerALaHoraCorrecta(carga);
		this.containers.add(carga.descargar());
	}

	
		/*
		 * Metodos auxiliares para corroborrar 
		 * que el Camion llega en Hora.
		 */
	private void camionLlegaConElContainerALaHoraCorrecta(Camion carga)  throws Exception  {
		if(!this.noEsLaMismaHoraDeLlegada(carga)) {
			throw new Exception("No llego a la hora acordada.");
		}
		
	}

	private boolean noEsLaMismaHoraDeLlegada(Camion carga) {
		return(true);
;	}

	
		/*
		 * Metodos auxiliares para corroborrar que 
		 * sea el Camion y Chofer correctos. 
		*/
	private void clienteInformóChoferYCamion(Camion carga) throws Exception  {
		if(!this.esChoferCorrecto(carga) || !this.esCamionCorresto(carga)) {
			throw new Exception("No esta autorizado.");
		}
	}

	private boolean esCamionCorresto(Camion carga) {
		return(ordenesActivas.stream().anyMatch(
				orden -> orden.getCamion().getNroDeSerie() ==
						carga.getNroDeSerie()
				));
	}

	private boolean esChoferCorrecto(Camion carga) {
		return(ordenesActivas.stream().anyMatch(
				orden -> orden.getChofer().equals(
						carga.getConductor())
				));
	}
	
		// Se encarga del accionar cuando un camion
		// de un Consignee (es decir, un camion sin carga
		// que viene a retirar una) llega al deposito.
	public void cargarCamion(Camion camion) {
		
	}
	
}
