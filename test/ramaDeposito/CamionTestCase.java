// Package.
package ramaDeposito;

// Imports.
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Clase a testear.
public class CamionTestCase {

	private Tanque mockTanque;
	private Chofer mockChofer;
	
	@BeforeEach
	public void setUp() {
		mockTanque = mock(Tanque.class);
        mockChofer = mock(Chofer.class);
	}
	
	// Test 1 --> Metodo descargar.
	@Test
    public void testDescargar() throws Exception {
        Camion camion = new Camion(
        		mockTanque, mockChofer, LocalDateTime.now()
        		);

        // Test del metodo descargar.
        Container descarga = camion.descargar();

        // Se verifica que  descargar devuelve el mock de tanque.
        assertEquals(mockTanque, descarga);

        // Se chequea que tire error al querer descargar de nuevo.
        Exception exception = assertThrows(
        		Exception.class, () -> {camion.descargar();}
        		);

        String mensajeEsperado = "No hay carga para descargar.";
        String mensajeActual = exception.getMessage();

        // Se chequea que el mensaje de error el correcto.
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }

	// Test 2 --> Metodo cargar.
	@Test
    public void testCargar() throws Exception {
        Camion camion1 = new Camion(
        		mockChofer, LocalDateTime.now());

        // Probar el método cargar.
        camion1.cargar(mockTanque);

        // Probar que se lanza una excepción al intentar cargar de nuevo.
        Exception exception = assertThrows(
        		Exception.class, () -> {camion1.cargar(mockTanque);}
        	);

        String mensajeEsperado = "No podes cargar el camion, ya tiene una carga.";
        String mensajeActual = exception.getMessage();

        // Asegurar que el mensaje es correcto.
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}
