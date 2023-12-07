package Terminal;

import java.util.List;

import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Tramo;

public class PlanMenorPrecioTotal extends Plan {

	//Menor precio total de recorrido entre origen y destino.

	@Override
	public Circuito operacion(TerminalNormal origen, 
			                  TerminalNormal destino,
			                  List<Circuito> circuitos) {
		
		Circuito mejorCircuito = null;	// El mejorcircuito al inicio no existe
        double menorCosto = Double.MAX_VALUE;	///Elegimos el maximo valor posible para que todos los que vengan despues sean menores


        //Recorremos los circuitos, obtenemos el costo total de cada uno y si este
        //es menor al anterior, guardamos dicho circuito como mejorCircuito.
        for (Circuito circuito : circuitos) {
            if (circuito.iniciaConTerminal(origen) && circuito.terminaConTerminal(destino)) {
                double costoTotal = calcularCostoTotal(circuito);
                if (costoTotal < menorCosto) {
                    menorCosto = costoTotal;
                    mejorCircuito = circuito;
                }
            }
        }

        return mejorCircuito;
    }
	
	//Acumulamos el costo de todos los tramos en el circuito y devolvemos ese valor.
	public double calcularCostoTotal(Circuito circuito) {
        double costoTotal = 0;
        for (Tramo tramo : circuito.getTramos()) {
            costoTotal += tramo.getCostoDelTramo();
        }
        return costoTotal;
    }
	
	
}
