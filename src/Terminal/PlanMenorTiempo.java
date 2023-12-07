package Terminal;

import java.util.List;

import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Tramo;

public class PlanMenorTiempo extends Plan {
	
	//Menor tiempo total de recorrido entre origen y destino.
	
	@Override
	public Circuito operacion(TerminalNormal origen,
							  TerminalNormal destino,
							  List<Circuito> circuitos) {
		
	Circuito mejorCircuito = null; //Iniciamos sin ningun "mejor circuito"
    double menorTiempo = Double.MAX_VALUE; //Elegimos el maximo valor posible para que todos los que vengan despues sean menores

    /*
     * Recorremos los circuitos y si inicia con origen y termina con destino
     * calculamos el tiempo total de los tramos y guardamos el mejor circuito
     * siempre y cuando dicho circuito tenga un tiempo total menor al anterior.
     */
    
    for (Circuito circuito : circuitos) {
        	if (circuito.iniciaConTerminal(origen) && circuito.terminaConTerminal(destino)) {
            	double tiempoTotal = calcularTiempoTotal(circuito.getTramos());
            	if (tiempoTotal < menorTiempo) {
                	menorTiempo = tiempoTotal;
                	mejorCircuito = circuito;
            	}
        	}
    	}

    	return mejorCircuito;
	}

	
	//Acumulamos la duracion de todos los tramos en la lista y devolvemos dicho valor
	public double calcularTiempoTotal(List<Tramo> tramos) {
    	double tiempoTotal = 0.0;

    	for (Tramo tramo : tramos) {
    		tiempoTotal += tramo.getDuracionDelTramo();
    	}

    	return tiempoTotal;
	}

	
	
	
}
