package ramaDeposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReeferTestCase {
	
	private	Reefer containerReefer;
	
	@BeforeEach
	public void setUp() {
		containerReefer = new Reefer(100, 150, 200, 2000, 100);
	}
	
	@Test
	public void testGetAncho() {
		assertEquals(100, containerReefer.getAncho());
	}
	
	@Test
	public void testGetLargo() {
		assertEquals(200, containerReefer.getLargo());
	}
	
	@Test
	public void testGetAlto() {
		assertEquals(150, containerReefer.getAltura());
	}
	
	@Test
	public void testGetPesoTotal() {
		assertEquals(2000, containerReefer.getPeso());
	}
	
	@Test
	public void testGetConsumo() {
		assertEquals(100, containerReefer.getConsumo());
	}
	
	@Test
	public void testCalcularConsumo() {
		assertEquals(2400, containerReefer.calcularConsumo(24));
	}
	
}
