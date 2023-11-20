package ramaDeposito;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDeTransporte {

	// Atributos.
	private List<Camion> flotaDeCamiones = new ArrayList<Camion>();
	private List<Chofer> empleados = new ArrayList<Chofer>();
	private String nombre;
	
	// Constructor.
	public EmpresaDeTransporte(List<Camion> camiones, List<Chofer> choferes, String nombre) {
		this.empleados = choferes;
		this.flotaDeCamiones = camiones;
		this.nombre = nombre;
	}
	
	// Metodos.
	public String getNombre() {
		return(this.nombre);
	}
	
}
