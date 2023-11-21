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
	public Container descargar() {
        Container containerParaDescargar = this.carga;
        this.carga = null; // el camión ya no tiene el contenedor
        return containerParaDescargar;
    }
}
