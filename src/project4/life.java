package project4;

import java.util.Scanner;

public class life {
	public static void main(String args[]) {
		System.out.println("What file would you like to use?");
		Scanner input = new Scanner(System.in);
		String file = input.nextLine();

		char[][] gen = readOriginal(file);
		printArray(gen);
		System.out
				.println("Would you like to see the next generation? Type play to continue");
		String answer = input.next();
		char[][] newGen = play(gen);
		printArray(newGen);
		System.out.println("\n");
		while (answer.equals("play")) {

			newGen = play(newGen);
			printArray(newGen);
			isEmpty(newGen);
			System.out
					.println("Would you like to keep playing? Type play to continue");
			answer = input.next();

		}
		if (!answer.equalsIgnoreCase("play")) {
			System.out.println("Goodbye!");
			System.exit(0);
		}

		input.close();

	}

	public static char[][] readOriginal(String file) {
		FileStringReader generation = new FileStringReader(file);
		char generation1[][] = new char[25][75];

		for (int i = 0; i < generation1.length; i++) {
			String line = generation.readLine();
			if (line != null) {
				for (int r = 0; r < generation1[i].length; r++) {

					generation1[i] = line.toCharArray();

				}
			}

		}

		return generation1;
	}

	public static char[][] play(char[][] gen) {
		char[][] newGen = new char[25][75];
		for (int row = 0; row < gen.length; row++) {
			for (int col = 0; col < gen[row].length; col++) {

				if ((gen[row][col] == 'X')
						&& (hasNeighbors(gen, row, col) == 2)) {
					newGen[row][col] = 'X';

				} else if (hasNeighbors(gen, row, col) == 3) {
					newGen[row][col] = 'X';

				}

				else {
					newGen[row][col] = '.';
				}

			}

		}

		return newGen;

	}

	@SuppressWarnings("finally")
	public static int hasNeighbors(char[][] grid, int r, int c) {
		int neighbors = 0;
		try {
			if ((grid[r][c - 1] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r][c + 1] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r + 1][c] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r - 1][c] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r + 1][c - 1] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r - 1][c + 1] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r + 1][c + 1] == 'X')) {
				neighbors = neighbors + 1;

			}
			if ((grid[r - 1][c - 1] == 'X')) {
				neighbors = neighbors + 1;

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw (e);

		} finally {

			return neighbors;
		}
	}

	public static void printArray(char generation[][]) {
		for (int row = 0; row < generation.length; row++) {
			for (int column = 0; column < generation[row].length; column++) {
				System.out.print(generation[row][column] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isEmpty(char[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (array[row][col] == 'X') {
					return true;
				}
			}

		}
		System.out.println("Your world is Empty!");
		System.exit(0);
		return false;
	}
}