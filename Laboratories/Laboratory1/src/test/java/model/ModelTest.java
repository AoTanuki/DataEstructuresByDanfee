package model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Model;

class ModelTest {

	private Model model = new Model();
	private int[] list1;
	private int[] list2;
	private float[] list3;
	private float[] list4;

	public void setupScenario1() {

		model = new Model();
		Object[] list1 = new Object[4];
		Object[] list2 = new Object[4];
		Random rad = new Random();

		model.fillListWithNumbersInAInterval(model.INTEGERS, model.NO_CLONE_NUMBERS, list1, 0, 999, rad);
		model.fillListWithNumbersInAInterval(model.INTEGERS, model.NO_CLONE_NUMBERS, list2, 0, 999, rad);
		ArrayList<Object[]> lit = new ArrayList<>();
		lit.add(list1);
		lit.add(list2);

	}

	public void setupScenary2() {
		model = new Model();
	}

	public void setupScenary3() {
		model = new Model();

		list1 = new int[] { 100, 7, 12, 14, 26, 9 };
		model.pigeonHoleSort(list1);
		list2 = new int[] { 7, 9, 12, 14, 26, 100 };

	}

	public void setupScenary4() {
		model = new Model();

		list1 = new int[] { 500, 14, 21, 74, 10, 9, 10, 42, 1, 8, 14 };

		model.pigeonHoleSort(list1);

		list2 = new int[] { 1, 8, 9, 10, 10, 14, 14, 21, 42, 74, 500 };

	}

	public void setupScenary5() {
		model = new Model();

		list1 = new int[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		model.pigeonHoleSort(list1);

		list2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	}

	public void setupScenary6() {
		model = new Model();

		list3 = new float[] { 10f, 9f, 8f, 7f, 6f, 5f, 4f, 3f, 2f, 1f };
		model.radixSort(list3);
		list4 = new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f };

	}

	public void setupScenary7() {
		model = new Model();

		list3 = new float[] { 20f, 19f, 18f, 17f, 16f, 15f, 14f, 13f, 12f, 11f, 10f, 9f, 8f, 7f, 6f, 5f, 4f, 3f, 2f,
				1f };
		model.radixSort(list3);
		list4 = new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f, 17f, 18f, 19f,
				20f };

	}

	public void setupScenary8() {
		model = new Model();

		list3 = new float[] { 14f, 13f, 12f, 6f, 5f, 10f, 20f, 4f, 3f, 2f, 11f, 19f, 18f, 17f, 16f, 15f, 9f, 8f,
				7f, 1f  };
		model.radixSort(list3);
		list4 = new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f, 17f, 18f,
				19f, 20f };

	}
	
	public void setupScenary9() {
		model = new Model();

		list3 = new float[] { 18f, 30f, 29f, 28f, 21f, 4f, 13f, 12f, 11f, 3f, 2f, 19f, 27f, 17f, 16f, 15f, 20f,
				7f, 6f, 5f, 26f, 25f, 24f, 23f, 22f, 14f, 10f, 9f, 8f, 1f };
		model.radixSort(list3);
		list4 = new float[] { 
				1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f, 17f, 18f,
				19f, 20f, 21f, 22f, 23f, 24f, 25f, 26f, 27f, 28f, 29f, 30f};

	}

	@Test
	public void testFillListWithNumbersInAInterval() {
		setupScenario1();
		model = new Model();
		Object[] list1 = new Object[4];
		Object[] list2 = new Object[4];
		Random rad = new Random();

		model.fillListWithNumbersInAInterval(model.FLOAT, model.NO_CLONE_NUMBERS, list1, 0, 999, rad);
		model.fillListWithNumbersInAInterval(model.FLOAT, model.NO_CLONE_NUMBERS, list2, 0, 999, rad);

		String all = "" + list1[0] + list1[1] + list1[2] + list1[3] + "";
		String all1 = "" + list2[0] + list2[1] + list2[2] + list2[3] + "";

		assertNotEquals(all, all1);

	}

	@Test
	public void testQuickSort() {

		model = new Model();
		int[] list = new int[] { 100, 7, 12, 14, 26, 9 };

		model.quickSort(list, list.length - 1, 0);

		int[] list2 = new int[] { 7, 9, 12, 14, 26, 100 };

		assertArrayEquals(list, list2);

		int[] list3 = new int[] { 500, 14, 21, 74, 10, 9, 10, 42, 1, 8, 14 };

		model.quickSort(list3, list3.length - 1, 0);

		int[] list4 = new int[] { 1, 8, 9, 10, 10, 14, 14, 21, 42, 74, 500 };

		assertArrayEquals(list3, list4);

		int[] list5 = new int[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		model.quickSort(list5, list5.length, 0);

		int[] list6 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		assertArrayEquals(list5, list6);
	}

	@Test
	public void testpigeonHoleSort() {

		setupScenary3();

		assertArrayEquals(list1, list2);

		setupScenary4();

		assertArrayEquals(list1, list2);

		setupScenary5();

		assertArrayEquals(list1, list2);

	}

	@Test
	public void testRadixSort() {

		setupScenary6();

		assertArrayEquals(list3, list4);

		setupScenary7();
		assertArrayEquals(list3, list4);

		setupScenary8();
		assertArrayEquals(list3, list4);

		setupScenary9();
		assertArrayEquals(list3, list4);

	}

	@Test
	void testReadNumbersFile01() {
		File integersFile = new File("./data/test/fileTest1Integers.txt");
		File floatsFile = new File("./data/test/fileTest1Floats.txt");
		try {
			model.readNumbersFile(integersFile, Model.INTEGERS);

			int[] list = model.getIntegerList();

			assertEquals(5000, list.length,
					"el tama�o que se espera es: 5000 " + "pero el arreglo tiene un tama�o de: " + list.length);

		} catch (Exception e) {
			fail(e.getMessage());
		}

		try {
			model.readNumbersFile(floatsFile, Model.FLOAT);

			float[] list = model.getFloatList();

			assertEquals(5000, list.length,
					"el tama�o que se espera es: 5000 " + "pero el arreglo tiene un tama�o de: " + list.length);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGenerateElementsSortGeneration() {

		try {

			int[] list;

			model.generateElements(5000, 0, 5000, Model.CLONE_NUMBERS, Model.SORT_GENERATION, Model.INTEGERS);
			list = model.getIntegerList();

			for (int i = 0; i < list.length - 1; i++) {

				if (!(list[i] <= list[i + 1])) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list[i]
							+ " debe ser menor que: " + list[i + 1]);
				} else {
					assertTrue(true);
				}

			}

			model.generateElements(5000, 1, 5000, Model.NO_CLONE_NUMBERS, Model.SORT_GENERATION, Model.INTEGERS);
			list = model.getIntegerList();

			for (int i = 0; i < list.length - 1; i++) {

				if (!(list[i] <= list[i + 1]) && list[i] != list[i + 1]) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list[i]
							+ " debe ser menor que: " + list[i + 1]);
				} else {
					assertTrue(true);
				}

			}

			// floats

			float[] list1;
			model.generateElements(5000, 0, 5000, Model.CLONE_NUMBERS, Model.SORT_GENERATION, Model.FLOAT);
			list1 = model.getFloatList();

			for (int i = 0; i < list1.length - 1; i++) {

				int bit1 = Float.floatToIntBits(list1[i]);
				int bit2 = Float.floatToIntBits(list1[i + 1]);
				if (!(bit1 <= bit2)) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list1[i]
							+ " debe ser menor que: " + list1[i + 1]);
				} else {
					assertTrue(true);
				}

			}

			model.generateElements(5000, 1, 5000, Model.NO_CLONE_NUMBERS, Model.SORT_GENERATION, Model.FLOAT);
			list1 = model.getFloatList();

			for (int i = 0; i < list1.length - 1; i++) {

				int bit1 = Float.floatToIntBits(list1[i]);
				int bit2 = Float.floatToIntBits(list1[i + 1]);

				if (!(bit1 <= bit2) && bit1 != bit2) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list1[i]
							+ " debe ser menor que: " + list1[i + 1]);
				} else {
					assertTrue(true);
				}

			}

		} catch (IOException e) {
			fail("there is a problem");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test
	void testSortPerformance() {
		fail("Not yet implemented");
	}

}
