package ramaDeposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


public class EmpresaDeTransporteTestCase {

	private EmpresaDeTransporte MDTransporte;
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> empleados = new ArrayList<Chofer>();
	@Mock private Camion camion1;
	@Mock private Camion camion2;
	@Mock private Camion camion3;
	@Mock private Chofer empleado1;
	@Mock private Chofer empleado2;
	@Mock private Chofer empleado3;
	
	@BeforeEach
	public void setUp() {
		camion1 = mock(Camion.class);
		camion2 = mock(Camion.class);
		empleado1 = mock(Chofer.class);
		empleado2 = mock(Chofer.class);
		camiones.add(camion1);
		camiones.add(camion2);
		empleados.add(empleado1);
		empleados.add(empleado2);
		MDTransporte = new EmpresaDeTransporte(camiones, empleados);
	}
	
	@Test
	public void testAddEmpleado() {
		empleado3 = mock(Chofer.class);
		MDTransporte.addEmpleados(empleado3);
		assertEquals(3, MDTransporte.getEmpleados().size());
	}
	
}
