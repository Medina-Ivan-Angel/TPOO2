package Terminal;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import ramaFasesDelBuque.Buque;
import ramaNavieraCircuitos.Tramo;
import ramaNavieraCircuitos.Viaje;

public class MotorBusqueda {

	private TerminalGestionada terminal;
	
	
	// Constructor.
	public MotorBusqueda(TerminalGestionada t) {
		this.terminal = t;
	}
	
	/*
	public Viaje puertoDestino(TerminalNormal tn) {
	    Comparator<Tramo> comparator = new Comparator<Tramo>() {
	        @Override
	        public int compare(Tramo t1, Tramo t2) {
	            return Double.compare(t1.getDuracionDelTramo(), t2.getDuracionDelTramo());
	        }
	    };
	    Optional<Tramo> tramoMinimo = this.terminal.getNavieras().stream()
	            .map(naviera -> naviera.getFlota())                    // Stream<List<Buque>>
	            .flatMap(List::stream)                                 // Aplanar el Stream<List<Buque>> a un Stream<Buque>
	            .map(Buque::getViaje)                                  // Stream<Viaje>
	            .map(viaje -> viaje.getCircuitoARecorrer())            // Stream de circuitos
	            .map(c -> c.getTramos())                               // Stream de lista de tramos
	            .flatMap(List::stream)                                 // Stream de tramos
	            .filter(t -> t.getOrigen().equals(terminal) && t.getDestino().equals(tn))                    
	            .min(comparator);                                      // Buscamos el tramo mas pequeño, es decir, el que tenga la duracionDelTramo mas pequeña (el double mas chico)

	    
	}
	*/
	
}
