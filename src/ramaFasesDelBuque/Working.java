package ramaFasesDelBuque;

public class Working implements Fase {
	
	/*
	 * Esta Fase indica que los trabajos de carga y descarga están en curso. Una 
	 * vez terminados, la terminal habilita la partida del buque 
	 * mediante la orden "depart". 
	 * */
	
	// ATRIBUTOS:
	
	private Fase proximoEstado = new Departing();
	
	// CONSTRUCTOR:
	
	public Working() {}
	 
	 // MÉTODOS:
	 
	@Override
	public void accion(Buque buque) {
		buque.setEstado(this.proximoEstado);
	}
		
}
