package stackExercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestCaseGenerator {

	public static void main(String[] args) throws IOException {

		File file = new File("./src/stackExercise/testCases.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		long size = 483631L;
		
		writer.write(size+ "\n");
		for (int i = 0; i < size; i++) {

			writer.write(generateRandomInput() + "\n");

		}

		writer.flush();
		writer.close();

	}

	private static String generateRandomInput() {

		StringBuilder sb = new StringBuilder();
		double x = Math.random();

		double n = x * 65429;
		n %= 200;

		for (int i = 0; i < n; i++) {

			x = Math.random();
			x *= 76456;
			x %= 100;
			char letter = x < 65 ? randomChar() : randomBracket();
			sb.append(letter);
		}

		return sb.toString();
	}

	private static char randomChar() {
		int rnd = (int) (Math.random() * 52);
		char base = (rnd < 26) ? 'A' : 'a';
		return (char) (base + rnd % 26);

	}

	private static char randomBracket() {
		char[] brackets = { '{', '}', '[', ']', '(', ')' };

		int rnd = (int) (Math.random() * 6);
		return brackets[rnd % brackets.length];

	}

}
