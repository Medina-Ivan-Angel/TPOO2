package ramaDeposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TanqueTestCase {

	private Tanque containerTanque;
	
	@BeforeEach
	public void setUp() {
		containerTanque = new Tanque(50, 60, 70, 1000);
	}
	
	@Test
	public void testGetAncho() {
		assertEquals(50, containerTanque.getAncho());
	}
	
	@Test
	public void testGetLargo() {
		assertEquals(70, containerTanque.getLargo());
	}
	
	@Test
	public void testGetAlto() {
		assertEquals(60, containerTanque.getAltura());
	}
	
	@Test
	public void testGetPesoTotal() {
		assertEquals(1000, containerTanque.getPeso());
	}
	
}
