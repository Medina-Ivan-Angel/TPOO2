package ramaAuxiliar;

public class MailAviso implements Mail {

	//Atributos
	private String mensaje;

	
	//Constructor
	public MailAviso(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	//Metodos
	
	
	//Getters and Setters
	public String getMensaje() {
		return this.mensaje;
	}
	
}
