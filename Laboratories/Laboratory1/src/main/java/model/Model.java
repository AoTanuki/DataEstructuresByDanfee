package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Danfee
 * @author Mike
 */
public class Model {

	/**
	 * 
	 */
	public static final char CLONE_NUMBERS = 'Y';

	/**
	 * 
	 */
	public static final char NO_CLONE_NUMBERS = 'N';

	/**
	 * 
	 */
	public static final String RADIX = "Radix Sort";

	/**
	 * 
	 */
	public static final String QUICK_SORT = "Quick Sort";

	/**
	 * 
	 */
	public static final String PIGEONHOLE_SORT = "PigeonHole Sort";

	/**
	 * 
	 */
	public static final char INTEGERS = 'i';

	/**
	 * 
	 */
	public static final char FLOAT = 'f';

	/**
	 * 
	 */
	public static final char SORT_GENERATION = 's';

	/**
	 * 
	 */
	public static final char INVERSAL_SORT_GENERATION = 'S';

	/**
	 * 
	 */
	public static final char COMPLETLY_RANDOM_GENERATION = 'c';

	/**
	 * 
	 */
	public static final char PERCENT_RANDOM_GENERATION = 'P';

	/**
	 * 
	 */
	private float[] floatList;

	/**
	 * 
	 */
	private float[] floatSortedList;

	/**
	 * 
	 */
	private int[] integerList;

	/**
	 * 
	 */
	private int[] integerSortedList;

	/**
	 * 
	 */
	private String message;

	/**
	 * Default constructor
	 */
	public Model() {
	}

	/**
	 * this method read the numbers within file and, depend of number type, chooses
	 * which converter uses finally, set the correct list with that numbers.
	 * 
	 * @param file       is the file that contain the set of number to sort
	 * @param numberType defines what kind of number are within file
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 */
	public void readNumbersFile(File file, char numberType)
			throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		switch (numberType) {
		case FLOAT:

			floatList = convertFileToFloatList(new BufferedReader(new FileReader(file)));
			break;

		case INTEGERS:

			integerList = convertFileToIntegerList(new BufferedReader(new FileReader(file)));
			break;
		}
	}

	/**
	 * this method converts the file in a float set.
	 * 
	 * @param buffer is the buffer that allow the method to read every line
	 * @return auxiliarList is the float set with every float within file
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 */
	public float[] convertFileToFloatList(BufferedReader buffer)
			throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		float[] auxiliarList = null;
		if (!buffer.readLine().equalsIgnoreCase("#set's size")) {
			throw new FileWithNoSetSizeException();
		}

		int size = Integer.parseInt(buffer.readLine());
		auxiliarList = new float[size];

		String line = buffer.readLine();

		if (line == null || line.isEmpty()) {
			throw new FileWithNotNumbersSet();
		}

		int numberline = 3;
		while (line != null && !line.isEmpty()) {

			if (!line.startsWith("#")) {
				line = line.trim();
				String[] lineList = line.split(" ");

				for (int i = 0; i < lineList.length; i++) {
					try {
						auxiliarList[i] = Float.parseFloat(lineList[i]);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(
								"There is a problem in your file, some value was not good write " + "\n the number is: "
										+ lineList[i] + " in the line: " + numberline + "  ");
					}
				}
			}

			numberline++;
			line = buffer.readLine();
		}

		buffer.close();
		return auxiliarList;
	}

	/**
	 * this method converts the file in a integer set.
	 * 
	 * @param buffer is the buffer that allow the method to read every line
	 * @return auxiliarList is the float set with every float within file
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 */
	public int[] convertFileToIntegerList(BufferedReader buffer)
			throws IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		int[] auxiliarList = null;
		if (!buffer.readLine().equalsIgnoreCase("#set's size")) {
			throw new FileWithNoSetSizeException();
		}

		int size = Integer.parseInt(buffer.readLine());
		auxiliarList = new int[size];

		String line = buffer.readLine();

		if (line == null || line.isEmpty()) {
			throw new FileWithNotNumbersSet();
		}

		int numberline = 3;
		while (line != null && !line.isEmpty()) {

			if (!line.startsWith("#")) {
				line = line.trim();
				String[] lineList = line.split(" ");

				for (int i = 0; i < lineList.length; i++) {
					try {
						auxiliarList[i] = Integer.parseInt(lineList[i]);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(
								"There is a problem in your file, some value was not good write " + "\n the number is: "
										+ lineList[i] + " in the line: " + numberline);
					}
				}

			}
			numberline++;
			line = buffer.readLine();
		}

		return auxiliarList;
	}

	/**
	 * this method decide which algorithm use to generate the random list to sort
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 * @throws IOException
	 */
	public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char generateType,
			char numberType) throws IOException {
		Random rand = new Random();
		Object[] list = null;
		switch (numberType) {
		case INTEGERS:

			switch (generateType) {
			case SORT_GENERATION:

				list = sortedElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;

			case INVERSAL_SORT_GENERATION:
				list = invertedElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;

			case COMPLETLY_RANDOM_GENERATION:

				list = completeRandomElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;
			}

			BufferedWriter writter = new BufferedWriter(new FileWriter("./data/numbersets/integersFile.txt"));

			writter.write("#set's size");
			writter.newLine();
			writter.write(list.length + "");
			writter.newLine();
			writter.write("#numbers set");
			writter.newLine();
//			String numberset = "";
			this.integerList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				this.integerList[i] = (int) list[i];
//				numberset+=integerList[i]+" ";
				writter.write(integerList[i] + " ");
			}

			writter.close();

			break;

		case FLOAT:

			switch (generateType) {
			case SORT_GENERATION:

				list = sortedElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;

			case INVERSAL_SORT_GENERATION:
				list = invertedElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;

			case COMPLETLY_RANDOM_GENERATION:
				list = completeRandomElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;
			}

			BufferedWriter writter1 = new BufferedWriter(new FileWriter("./data/numbersets/floatsFile.txt"));
			writter1.write("#set's size");
			writter1.newLine();
			writter1.write(list.length + "");
			writter1.newLine();
			writter1.write("#numbers set");
			writter1.newLine();
//			String numberset1 = "";
			this.floatList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				this.floatList[i] = (float) list[i];
				writter1.write(floatList[i] + " ");
			}

			writter1.close();

			break;
		}

	}

	/**
	 * this method decide which algorithm use to generate the random list to sort
	 * but in a segment way
	 * 
	 * @param size             is the length of the list
	 * @param startInterval    define the interval's start of numbers what user want
	 * @param endInterval      define the interval's end of numbers what user want
	 * @param cloneNumber      this parameter define if the list would has numbers
	 *                         clone
	 * @param numberType       define which type of number is.
	 * @param randomPorcentage is a double that define how much is disordered the
	 *                         list
	 */
	public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType,
			double randomPorcentage) {

		Random rand = new Random();
		Object[] list = null;

		list = segmentalRandomElements(size, startInterval, endInterval, cloneNumber, numberType, rand,
				randomPorcentage);

		switch (numberType) {
		case FLOAT:

			this.floatList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				this.floatList[i] = (float) list[i];
			}
			break;

		case INTEGERS:

			this.integerList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				this.integerList[i] = (int) list[i];
			}
			break;
		}
	}

	// this method fill the list with numbers in a interval.
	public void fillListWithNumbersInAInterval(char numberType, char cloneNumber, Object[] list, int startInterval,
			int endInterval, Random rand) {
		for (int i = 0; i < list.length; i++) {
			if (numberType == FLOAT) {
				list[i] = startInterval + (endInterval - startInterval) * rand.nextFloat();
			} else {
				if (cloneNumber == NO_CLONE_NUMBERS) {
					list[i] = startInterval + i;
				} else {
					list[i] = (int) Math.floor(Math.random() * (startInterval - (endInterval + 1)) + endInterval);
				}
			}
		}

	}

	/**
	 * this method create a list with the numbers in the interval but in random
	 * position.
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 * @return list is a object array that provide a list with the numbers in the
	 *         interval but in random position. This list only has one type of
	 *         number. it is defined by the parameter "numberType"
	 */
	public Object[] completeRandomElements(int size, int startInterval, int endInterval, char cloneNumber,
			char numberType, Random rand) {

		// if we need to create a list without clone numbers and the number types are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size && numberType == INTEGERS)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];

		// fill the list with numbers in the interval
		fillListWithNumbersInAInterval(numberType, cloneNumber, list, startInterval, endInterval, rand);

		for (int i = 0; i < list.length; i++) {
			int randomIndex = (int) Math.floor(Math.random() * ((list.length)));

			Object temp = list[i];
			list[i] = list[randomIndex];
			list[randomIndex] = temp;

		}

		for (int i = 0; i < list.length; i++) {
			message += list[i] + " - ";
		}

		return list;
	}

	/**
	 * this method create a list with the numbers in the interval but sorted
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 * @return list is a object array that provide a list with the numbers in the
	 *         interval but sorted. This list only has one type of number. it is
	 *         defined by the parameter "numberType"
	 */
	public Object[] sortedElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType,
			Random rand) {

		// if we need to create a list without clone numbers and the numbertypes are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];

		// fill the list with numbers in the interval
		fillListWithNumbersInAInterval(numberType, cloneNumber, list, startInterval, endInterval, rand);

		// sort the list depend its type, if the numbers are integers, they would be
		// sorted by pigeonSort. Else, they would be sorted by radixsort
		if (numberType == FLOAT) {
			float[] auxiliarList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (float) list[i];
			}
			radixSort(auxiliarList);

			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
				message += list[i] + " - ";
			}
		} else {
			int[] auxiliarList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (int) list[i];
			}

			pigeonHoleSort(auxiliarList);

			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
				message += list[i] + " - ";
			}
		}

		return list;
	}

	/**
	 * this method create a list with the numbers in the interval but sorted and
	 * inverted.
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 * @return list is a object array that provide a list with the numbers in the
	 *         interval but sorted in a inverted form. This list only has one type
	 *         of number. it is defined by the parameter "numberType"
	 */
	public Object[] invertedElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType,
			Random rand) {

		// if we need to create a list without clone numbers and the numbertypes are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size && numberType == INTEGERS)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];

		// fill the list with numbers in the interval
		fillListWithNumbersInAInterval(numberType, cloneNumber, list, startInterval, endInterval, rand);

		// sort the list depend its type, if the numbers are integers, they would be
		// sorted by pigeonSort. Else, they would be sorted by radixsort
		if (numberType == FLOAT) {
			float[] auxiliarList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (float) list[i];
			}
			radixSortInverted(auxiliarList);

			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
				message += list[i] + " - ";
			}
		} else {
			int[] auxiliarList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (int) list[i];
			}

			pigeonHoleSortInverted(auxiliarList);

			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
				message += list[i] + " - ";
			}
		}

		return list;
	}

	/**
	 * 
	 * 
	 * @param size             is the length of the list
	 * @param startInterval    define the interval's start of numbers what user want
	 * @param endInterval      define the interval's end of numbers what user want
	 * @param cloneNumber      this parameter define if the list would has numbers
	 *                         clone
	 * @param numberType       define which type of number is.
	 * @param randomPorcentage is a double that define how much is disordered the
	 *                         list
	 * @return list is a object array that provide a list with the numbers in the
	 *         interval but sorted in a inverted form. This list only has one type
	 *         of number. it is defined by the parameter "numberType"
	 */
	public Object[] segmentalRandomElements(int size, int startInterval, int endInterval, char cloneNumber,
			char numberType, Random rand, double randomPorcentage) {

		// if we need to create a list without clone numbers and the numbertypes are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size && numberType == INTEGERS)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];
		message = "";
		// generate sorted list
		list = sortedElements(size, startInterval, endInterval, cloneNumber, numberType, rand);

		for (int positionsDisordered = (int) (size
				* randomPorcentage); positionsDisordered > 0; positionsDisordered -= 2) {

			int index1 = (int) Math.floor(Math.random() * ((size)));
			int index2 = (int) Math.floor(Math.random() * ((size)));

			while (index2 == index1) {
				index2 = (int) Math.floor(Math.random() * ((size)));
			}

			Object temp = list[index1];
			list[index1] = list[index2];
			list[index2] = temp;
		}

		for (int i = 0; i < list.length; i++) {
			message += list[i] + " - ";
		}
		return list;
	}

	/**
	 * Modifica la lista correspondiente al tipo de numero de forma ordenada y
	 * retroalimenta
	 * 
	 * @param numbertype
	 * @return info devuelve una lista con la informacion de la siguiente forma:
	 *         [o]:Runtime (long), [1]:algoritmo usado(String)
	 */
	public Object[] sortPerformance(char numbertype) {

		Object[] info = new Object[2];

		long timeStart = 0;
		long runtime = 0;
		String algorithm = " ";

		switch (numbertype) {
		case FLOAT:
			algorithm = RADIX;
			floatSortedList = floatList.clone();

			timeStart = System.currentTimeMillis();
			radixSort(floatSortedList);
			runtime = System.currentTimeMillis() - timeStart;
			break;

		case INTEGERS:
			integerSortedList = integerList.clone();
			if (integerSortedList.length <= 2500) {
				algorithm = QUICK_SORT;
				timeStart = System.currentTimeMillis();
				quickSort(integerSortedList, integerSortedList.length - 1, 0);
				runtime = System.currentTimeMillis() - timeStart;

			} else {
				algorithm = PIGEONHOLE_SORT;
				timeStart = System.currentTimeMillis();
				
				pigeonHoleSort(integerSortedList);
				runtime = System.currentTimeMillis() - timeStart;
				
			}
			break;
		}

		info[0] = runtime;
		info[1] = algorithm;
		return info;
	}

	/**
	 * @param list
	 * @return
	 */
	public void quickSort(int[] list, int high, int low) {

		if (low < high) {
			int partition = partition(list, low, high);

			quickSort(list, low, partition - 1);
			quickSort(list, partition + 1, high);
		}

	}

	private int partition(int[] list, int low, int high) {

		int pivot = list[high];
		int smallerElementIndex = (low - 1);

		for (int i = low; i < high; i++) { 

			if (list[i] <= pivot) {
				smallerElementIndex++;

				// Swap list[samallerElementIndex] and list[i]

				int temp = list[smallerElementIndex];
				list[smallerElementIndex] = list[i];
				list[i] = temp;
			}
		}

		// swap list[smallerElementIndex+1] and list[high] (or pivot)
		int temp = list[smallerElementIndex + 1];
		list[smallerElementIndex + 1] = list[high];
		list[high] = temp;

		return smallerElementIndex+1;
	}

	/**
	 * @param list
	 * @return
	 */
	public void pigeonHoleSort(int[] list) {

		// find the minimum and the maximums valor
		int minimun = list[0];
		int maximun = list[0];

	
		for (int i = 0; i < list.length; i++) {
			if (list[i] > maximun)
				maximun = list[i];
			if (list[i] < minimun)
				minimun = list[i];
		}
		
		

		// find the range of holes
		int range = maximun - minimun + 1;

		
		int[] pigeonHoles = new int[range];

		// put every element in its respective hole
		for (int i = 0; i < list.length; i++) {
			int index = list[i] - minimun;
			pigeonHoles[index]++;
		}

		int index = 0;

		// for every hole, take its elements and put in array
		for (int i = 0; i < range; i++) {
			while (pigeonHoles[i]-- > 0) {
				list[index++] = i + minimun;
			}
		}
		
	
	}

	/**
	 * @param list
	 * @return
	 */
	public void pigeonHoleSortInverted(int[] list) {

		// find the minimum and the maximums valor
		int minimun = list[0];
		int maximun = list[0];

		for (int i = 0; i < list.length; i++) {
			if (list[i] > maximun)
				maximun = list[i];
			if (list[i] < minimun)
				minimun = list[i];
		}

		// find the range of holes
		int range = maximun - minimun + 1;

		int[] pigeonHoles = new int[range];

		// put every element in its respective hole
		for (int i = 0; i < list.length; i++) {
			int index = list[i] - minimun;
			pigeonHoles[index]++;
		}

		int index = list.length - 1;

		// for every hole, take its elements and put in array
		for (int i = 0; i < range; i++) {
			while (pigeonHoles[i]-- > 0) {
				list[index--] = i + minimun;

			}
		}
	}

	/**
	 * @param list
	 * @return
	 */
	public void radixSort(float[] list) {

		float maximus = getMax(list);

		int bitMaximus = Float.floatToIntBits(maximus);

		for (int exp = 1; bitMaximus / exp > 0; exp *= 10) {

			countSort(list, exp);
		}
	}

	private void countSort(float[] list, int exp) {

		int[] outPut = new int[list.length];
		int[] count = new int[10];

		for (int i = 0; i < list.length; i++) {
			int bitRepre = Float.floatToIntBits(list[i]);
			count[(bitRepre / exp) % 10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = list.length - 1; i >= 0; i--) {

			int bitRepre = Float.floatToIntBits(list[i]);
			outPut[count[(bitRepre / exp) % 10] - 1] = bitRepre;
			count[(bitRepre / exp) % 10]--;
		}

		for (int i = 0; i < list.length; i++) {
			list[i] = Float.intBitsToFloat(outPut[i]);
		}

	}

	public float getMax(float[] list) {
		int bitMax = Float.floatToIntBits(list[0]);

		for (int i = 0; i < list.length; i++) {
			int bitTemp = Float.floatToIntBits(list[i]);

			if (bitTemp > bitMax)
				bitMax = bitTemp;
		}

		float maximun = Float.intBitsToFloat(bitMax);

		return maximun;
	}

	/**
	 * @param list
	 * @return
	 */
	public void radixSortInverted(float[] list) {

		float maximus = getMax(list);
		System.out.println(maximus);

		int bitMaximus = Float.floatToIntBits(maximus);

		for (int exp = 1; bitMaximus / exp > 0; exp *= 10) {

			countSortInverted(list, exp);
		}

		for (int i = 0; i < list.length; i++) {
			float temp = list[list.length - 1 - i];

			list[i] = list[list.length - 1 - i];
			list[list.length - 1 - i] = temp;

		}
	}

	private void countSortInverted(float[] list, int exp) {

		int[] outPut = new int[list.length];
		int[] count = new int[10];

		for (int i = 0; i < list.length; i++) {
			int bitRepre = Float.floatToIntBits(list[i]);
			count[(bitRepre / exp) % 10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = list.length - 1; i >= 0; i--) {

			int bitRepre = Float.floatToIntBits(list[i]);
			outPut[count[(bitRepre / exp) % 10] - 1] = bitRepre;
			count[(bitRepre / exp) % 10]--;
		}

		for (int i = 0; i < list.length; i++) {

			list[i] = Float.intBitsToFloat(outPut[i]);
		}

	}

	public float[] getFloatList() {
		return floatList;
	}

	public void setFloatList(float[] floatList) {
		this.floatList = floatList;
	}

	public float[] getFloatSortedlist() {
		return floatSortedList;
	}

	public void setFloatSortedList(float[] floatSortedist) {
		this.floatSortedList = floatSortedist;
	}

	public int[] getIntegerList() {
		return integerList;
	}

	public void setIntegerList(int[] integerList) {
		this.integerList = integerList;
	}

	public int[] getIntegerSortedList() {
		return integerSortedList;
	}

	public void setIntegerSortedList(int[] integerSortedist) {
		this.integerSortedList = integerSortedist;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}