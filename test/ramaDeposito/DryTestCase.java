package ramaDeposito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DryTestCase {

	private Dry containerDry;
	
	@BeforeEach
	public void setUp() {
		containerDry = new Dry(30, 50, 80, 200);
	}
	
	@Test
	public void testGetAncho() {
		assertEquals(30, containerDry.getAncho());
	}
	
	@Test
	public void testGetLargo() {
		assertEquals(80, containerDry.getLargo());
	}
	
	@Test
	public void testGetAlto() {
		assertEquals(50, containerDry.getAltura());
	}
	
	@Test
	public void testGetPesoTotal() {
		assertEquals(200, containerDry.getPeso());
	}
}
