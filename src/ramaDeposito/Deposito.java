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
	
}
