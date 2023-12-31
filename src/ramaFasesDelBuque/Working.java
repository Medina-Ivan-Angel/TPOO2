package ramaFasesDelBuque;

public class Working implements Fase {
	
	/*
	 * Esta Fase indica que los trabajos de carga y descarga están en curso. Una 
	 * vez terminados, la terminal habilita la partida del buque 
	 * mediante la orden "depart". 
	 * */
	
	// ATRIBUTOS:
	private Fase proximoEstado = new Departing();
	 
	 // MÉTODOS:
	 
	@Override
	public void accion(Buque buque) {
		buque.getTerminalGestionada().depart(buque);
		buque.setEstado(this.proximoEstado);
		
	}
		
}
