package ramaNavieraCircuitos;
import java.util.List;
import java.util.ArrayList;

public class Circuito {
	
	private List<Tramo> tramos;
	
	public Circuito(List<Tramo> tramos) {
		this.tramos = new ArrayList<Tramo>();
	}
	
	/*
	 * Se crearon los getters y setters para el atributo tramos de esta clase, 
	 * porque se van a utilizar al momento de realizar los tests.
	 * Además, por la manera en la que se inicializó la lista, 
	 * se va a agregar cada elemento de forma individual, 
	 * en el apartado setUp de cada uno de los tests en las que se utilicen.
	 * */
	
	public List<Tramo> getTramos() {
		return this.tramos;
	}
	
	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	public void agregarTramo(Tramo tramo) {
		this.tramos.add(tramo);
	}

}
