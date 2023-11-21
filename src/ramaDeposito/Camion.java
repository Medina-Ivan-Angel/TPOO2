// Package de la clase.
package ramaDeposito;

public class Camion {

	// Atributos.
	private Container carga;
	private Chofer conductor;
	private int nroDeSerie;
	private String hraDeLlegada;
	
	// Constructor.
	public Camion(Container carga, Chofer conductor, int nroDeSerie, String hra) {
		this.carga = carga;
		this.conductor = conductor;
		this.nroDeSerie = nroDeSerie;
		this.hraDeLlegada = hra;
	}
	
	// Metodos.
		// Getters.
	public Chofer getConductor() {
		return(this.conductor);
	}
	
	public int getNroDeSerie() {
		return(this.nroDeSerie);
	}
	
	public String getHraDeLlegada() {
		return(this.hraDeLlegada);
	}
	
		/*
		 * Metodo para cuando se confirma que es el camion
		 * correcto para descargarlo.
		*/
	public Container descargar() throws Exception {
        this.validarQueTieneCarga();
		Container containerParaDescargar = this.carga;
        this.carga = null; // el camión ya no tiene el contenedor
        return containerParaDescargar;
    }

		// Se chequea que tenga una carga el camion
		// antes de querer descargarse.
	private void validarQueTieneCarga() throws Exception {
		if(carga == null) {
			throw new Exception("No hay carga para descargar.");
		}
	}
	
		/*
		 * Metodo para cuando se confirma que es el camion
		 * correcto para darle la carga del consignee.
		 */ 
	public void cargar(Container carga) throws Exception {
		this.validarQueEstaVacio();
		this.carga = carga;
	}

		// Se cheque que este vacio el camion.
	private void validarQueEstaVacio() throws Exception {
		if(this.carga != null) {
			throw new Exception("No podes cargar el camion, ya tiene una carga.");
		}
	}
}
