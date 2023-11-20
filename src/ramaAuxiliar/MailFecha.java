package ramaAuxiliar;

import java.time.LocalDateTime;

public class MailFecha implements Mail {

	//Atributos
	private LocalDateTime fecha;

	
	
	//Constructor
	public MailFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	//Metodos
	
	
	//Getters and Setters
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	
	
}
