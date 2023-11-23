// Package de la clase.
package ramaDeposito;

// Imports.
import java.util.ArrayList;
import java.util.List;

public class EmpresaDeTransporte {

	// Atributos.
	private List<Camion> flotaDeCamiones = new ArrayList<Camion>();
	private List<Chofer> empleados = new ArrayList<Chofer>();
	
	
	// Constructor.
	public EmpresaDeTransporte(List<Camion> camiones, List<Chofer> choferes) {
		this.empleados = choferes;
		this.flotaDeCamiones = camiones;
	}
	
	
	// Metodos.
		// Agregar Empleados y camiones.
	public void addEmpleados(Chofer chofer) {
		this.empleados.add(chofer);
	}
	
	public void addCamion(Camion camion) {
		this.flotaDeCamiones.add(camion);
	}
	
	
}
