package ramaFasesDelBuque;

public class Working implements Fases {

	public Working() {}
	
	
	/*
	 * El enunciado dice que el proceso de carga y descarga de los containers no 
	 * será contemplado en este trabajo.
	 * Por lo tanto, con preguntar de alguna manera si el buque terminó su trabajo 
	 * pasa automaticamente a la siguiente y última fase.
	 * 
	 * */
	@Override
	public void accion(Buque buque) {
		if (finalizóElTrabajo()) {
			return buque.setEstado(Departing);
		}
		
	public boolean finalizóElTrabajo() {
		return true;
	}

}
