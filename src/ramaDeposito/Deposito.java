// Package de la clase.
package ramaDeposito;

// Imports de Java.
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
// Import de clases del Tp.
import ramaCliente.Orden.Orden;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Orden.OrdenImportacion;
import ramaCliente.Servicios.AlmacenamientoExcedente;

public class Deposito {

	// Atributos.
	private List<Orden> ordenesActivas = new ArrayList<Orden>();
	private List<Container> containers = new ArrayList<Container>();
	private double costoPorDia; // Es el costo que le tengo que cobrar a un consignee por
								// almacenamiento excedente.
	
	// Constructor.
	public Deposito(List<Orden> ordenes, List<Container> carga, double costo) {
		this.ordenesActivas = ordenes;
		this.containers = carga;
		this.costoPorDia = costo;
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
	public void registrarCargaEnElPuerto(Camion camion) throws Exception {
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
	    for (Orden orden : ordenesActivas) {
	        if (orden.getCamion().equals(camion)) {
	            LocalDateTime horaDeLlegadaCamion = camion.getHraDeLlegada();

	            if (orden instanceof OrdenExportacion) {
	                LocalDateTime horaDeLlegadaOrden = ((OrdenExportacion) orden).getFechaSalidaDeCarga();
	                long diferenciaEnHoras = ChronoUnit.HOURS.between(horaDeLlegadaCamion, horaDeLlegadaOrden);

	                if (Math.abs(diferenciaEnHoras) <= 3) {
	                    return(true);
	                }
	            }
	        }
	    }
	    return(false);
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
	public void cargarCamion(Camion camion) throws Exception {
		this.clienteInformóChoferYCamion(camion);
		this.camionLlegoDentroDeLasHorasAsignadas(camion);
		camion.cargar(this.containerCorrespondiente(camion));
	}


	private void camionLlegoDentroDeLasHorasAsignadas(Camion camion) {
		if(!this.noPasaron24Hrs(camion)) {
			for (Orden orden : ordenesActivas) {
				if (orden.getCamion().equals(camion)) {
					orden.addServicio(new AlmacenamientoExcedente(this.costoPorDia, this.calcularEstadia(camion)));
	            }
			}
		}
	}


	private double calcularEstadia(Camion camion) {
		return(this.calcularCantDeHoras(camion) * this.costoPorDia);
	}


	private double calcularCantDeHoras(Camion camion) {
		for (Orden orden : ordenesActivas) {
			if (orden.getCamion().equals(camion)) {
				LocalDateTime horaDeLlegadaCamion = camion.getHraDeLlegada();

				if (orden instanceof OrdenImportacion) {
					LocalDateTime horaDeLlegadaOrden = ((OrdenImportacion) orden).getfechaLlegadaDeCarga();
					long diferenciaEnHoras = ChronoUnit.HOURS.between(horaDeLlegadaCamion, horaDeLlegadaOrden);
					return(Math.abs(diferenciaEnHoras));
				}
			}
    	}
		return(Math.abs(diferenciaEnHoras));
		//return costoPorDia;
	}
	
	private boolean noPasaron24Hrs(Camion camion) {
		if (this.calcularCantDeHoras(camion) <= 24) {
			return true;
		} else {
			return false;
		}
	    
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
