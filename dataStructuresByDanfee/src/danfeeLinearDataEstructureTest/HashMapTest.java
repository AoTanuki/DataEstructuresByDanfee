package danfeeLinearDataEstructureTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import danfeeLinearDataEstructures.HashMap;

class HashMapTest {

	private HashMap<String, Integer> hash;
	private String[] mensaje;
	private Integer[] numero;

	private void setScene1() {
		String[] mensajes = { "hola", "Ayer", "mañana", "carcer", "Peder" };
		Integer[] numeros = { 1, 2, 3, 4, 5 };
		mensaje = mensajes;
		numero = numeros;
		hash = new HashMap<>();
	}

	private void setScene2() {
		String[] mensajes = { "hola", "hola", "Culebra", "Culebra", "Peder" };
		Integer[] numeros = { 1, 2, 3, 4, 5 };
		mensaje = mensajes;
		numero = numeros;
		hash = new HashMap<>();
	}

	private void setScene3() {
		String[] mensajes = { "1", "2", "3", "4|", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14|", "15", "16",
				"17", "18", "19" };
		
		mensaje = mensajes;
		hash = new HashMap<>();
	}

	private void setScene4() {
		mensaje = new String[10000000];
		numero = new Integer[10000000];
		for (int i = 0; i < mensaje.length; i++) {
			mensaje[i] = i + "";
			numero[i] = i;
		}
		hash = new HashMap<>();
	}

	@Test
	void test1() {

		setScene1();
		boolean añadido = true;
		for (int i = 0; i < mensaje.length; i++) {
			añadido = hash.put(mensaje[i], numero[i]) && añadido;

		}
		assertEquals(true, añadido);
	}

	@Test
	void test2() {

		setScene2();
		int[] agregados = { 0, 0, 0, 0, 0 };

		for (int i = 0; i < mensaje.length; i++) {
			if (hash.put(mensaje[i],numero[i])) {
				agregados[i] = 1;
			}
		}

		assertEquals(1, agregados[0]);
		assertEquals(1, agregados[2]);
		assertEquals(1, agregados[4]);
		

		
		assertTrue(hash.get("hola")==2, "we expect that for inpunt <hola> the output should be 3. Insteand, the output was: "+ hash.get("hola"));
		assertTrue(hash.get("Culebra")==4, "we expect that for inpunt <Culebra> the output should be 4. Insteand, the output was: "+ hash.get("Culebra"));
		assertTrue(hash.get("Peder")==5, "we expect that for inpunt <Peder> the output should be 5. Insteand, the output was: "+ hash.get("Peder"));
		
		assertTrue(hash.get("I don't exist")== null,"we expect that for inpunt <I don't exist> the output should be null. Insteand, the output was: "+ hash.get("I don't exit"));
	
	}


	
	@Test
	void test5() {

		setScene4();

		for (int i = 0; i < mensaje.length; i++) {
			hash.put(mensaje[i],numero[i]);
		}

		
//		for (int i = 0; i < mensaje.length; i++) {
//			encontrados = encontrados && hash.contains(mensaje[i]);
//			
//		}

		assertEquals(null, hash.get("-1"));
		assertEquals(10000000, hash.size());
	}

}
