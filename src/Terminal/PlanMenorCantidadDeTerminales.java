package Terminal;

import java.util.List;

import ramaNavieraCircuitos.Circuito;

public class PlanMenorCantidadDeTerminales extends Plan{

	//Menor cantidad de terminales intermedias entre origen y destino

	@Override
	public Circuito operacion(TerminalNormal origen, 
							  TerminalNormal destino,
							  List<Circuito> circuitos) {

		Circuito circuitoMinimo = null; //Al inicio no hay circuito minimo
        int terminalesMinimas = Integer.MAX_VALUE; // Elegimos el entero de mayor valor para que los siguientes siempre sean menores

        for (Circuito circuito : circuitos) {
            // Verificar si el circuito conecta el origen y el destino
            if (circuito.getTramos().get(0).getOrigen().equals(origen) &&
            	circuito.getTramos().get(circuito.getTramos().size() - 1).getDestino().equals(destino)) {
                // Calcular la cantidad de terminales intermedias
                int terminalesIntermedias = circuito.getTramos().size() - 1;

                // Actualizar el circuito mínimo si es el caso
                if (terminalesIntermedias < terminalesMinimas) {
                    terminalesMinimas = terminalesIntermedias;
                    circuitoMinimo = circuito;
                }
            }
        }

        return circuitoMinimo;
    }
		
		
}
