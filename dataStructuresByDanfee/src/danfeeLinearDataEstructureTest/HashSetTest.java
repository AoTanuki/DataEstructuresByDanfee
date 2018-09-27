package danfeeLinearDataEstructureTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import danfeeLinearDataEstructures.HashSet;

class HashSetTest {

	private HashSet<String> hash;
	private String[] mensaje;

	private void setScene1() {
		String[] mensajes = { "hola", "Ayer", "mañana", "carcer", "Peder" };
		mensaje = mensajes;
		hash = new HashSet<>();
	}

	private void setScene2() {
		String[] mensajes = { "hola", "hola", "Culebra", "Culebra", "Peder" };
		mensaje = mensajes;
		hash = new HashSet<>();
	}
	
	private void setScene3() {
		String[] mensajes= {"1","2","3","4|","5","6","7","8","9","10","11","12","13","14|","15","16","17","18","19"};
		mensaje = mensajes;
		hash = new HashSet<>();
	}
	
	private void setScene4() {	
		mensaje = new String[10000000];
		for (int i = 0; i < mensaje.length; i++) {
			mensaje[i]=i+"";
		}
		hash = new HashSet<>();
	}

	@Test
	void test1() {

		setScene1();
		boolean añadido = true;
		for (int i = 0; i < mensaje.length; i++) {
			añadido = hash.add(mensaje[i]) && añadido;

		}
		assertEquals(true, añadido);
	}

	@Test
	void test2() {

		setScene2();
		int[] agregados = { 0, 0, 0, 0, 0 };

		for (int i = 0; i < mensaje.length; i++) {
			if (hash.add(mensaje[i])) {
				agregados[i] = 1;
			}

		}

		assertEquals(1, agregados[0]);
		assertEquals(1, agregados[2]);
		assertEquals(1, agregados[4]);
	}

	@Test
	void test3() {

		setScene2();
		

		for (int i = 0; i < mensaje.length; i++) {
			hash.add(mensaje[i]);
		}
		
		boolean encontrados = true;
		for (int i = 0; i < mensaje.length; i++) {
			encontrados = encontrados && hash.contains(mensaje[i]);
			
		}

		assertEquals(true, encontrados);
	}
	
	@Test
	void test4() {

		setScene3();
		

		for (int i = 0; i < mensaje.length; i++) {
			hash.add(mensaje[i]);
		}
		
		boolean encontrados = true;
		for (int i = 0; i < mensaje.length; i++) {
			encontrados = encontrados && hash.contains(mensaje[i]);
			
		}
		assertEquals(true, encontrados);
		assertEquals(19, hash.size());
	}

	@Test
	void test5() {

		setScene4();
		

		for (int i = 0; i < mensaje.length; i++) {
			hash.add(mensaje[i]);
		}
		
		boolean encontrados = true;
		for (int i = 0; i < mensaje.length; i++) {
			encontrados = encontrados && hash.contains(mensaje[i]);
			
		}
		assertEquals(true, encontrados);
		assertEquals(10000000, hash.size());
	}
}
