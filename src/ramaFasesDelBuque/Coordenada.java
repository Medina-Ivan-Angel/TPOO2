package ramaFasesDelBuque;

public class Coordenada {
	
	private int valorX;
	private int valorY;
	
	public Coordenada(int valorX, int valorY) {
		this.valorX = valorX;
		this.valorY = valorY;
	}
	
	/*
	 * Se crearon los getters y setters para poder asignar valores a elección
	 * a las coordenadas de un buque.
	 * */ 
	
	public int getValorX() {
		return this.valorX;
	}
	
	public void setValorX(int coordenadaX) {
		this.valorX = coordenadaX;
	}
	
	public int getValorY() {
		return this.valorY;
	}
	
	public void setValorY(int coordenadaY) {
		this.valorY = coordenadaY;
	}
		

}
