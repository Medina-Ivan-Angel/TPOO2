package ramaCliente;

import java.util.ArrayList;
import java.util.List;

public interface Orden {

	//Atributos
	List<Servicio> servicios = new ArrayList<Servicio>();
	
	
	//Metodos
	public Cliente cliente();
	public Container carga(); // TODO: falta implementar container por Victor.
	
	
	
}
