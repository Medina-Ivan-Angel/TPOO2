// Package.
package ramaDeposito;

// Imports.
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
	public void registrarCargaEnElPuerto(Camion carga) {
		this.clienteInformóChoferYCamion(carga);
		//this.estaElCamionYChoferAutorizadosPorElConsignee(carga);
		this.camionLlegaConElContainerALaHoraCorrecta(carga);
		this.containers.add(carga.descargar());
	}

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
	
}
