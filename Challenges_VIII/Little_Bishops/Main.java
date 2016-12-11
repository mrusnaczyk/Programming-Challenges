package Challenges_VIII.Little_Bishops;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<String> placedBishops;
	static int numBishops;
	static int numPlacements;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sizeOfBoard = 0;
		numBishops = 0;

		while ((sizeOfBoard = s.nextInt()) != 0 && (numBishops = s.nextInt()) != 0) {
			numPlacements = 0;
			placedBishops = new ArrayList<String>();
			backtrack(1, sizeOfBoard);
			System.out.println(numPlacements);

		}

	}

	public static void backtrack(int row, int n) {
		// n is the number of columns on the board
		// i is the current column
		if (row <= n) {
			for (int i = 1; i <= n; i++) {
				boolean isSafe = true;
				for (String b : placedBishops) {
					String[] point = b.split(",");
					int[] coord = { Integer.parseInt(point[0]), Integer.parseInt(point[1]) };

					if (Math.abs(row - coord[0]) == Math.abs(i - coord[1])) {
						isSafe = false;
						break;
					}
				}

				// Place a Bishop in the cell if it's safe to do so
				if (isSafe) {
					placedBishops.add(String.valueOf(row) + "," + String.valueOf(i));
					System.out.println("*** " + row + "," + i + " is safe. ***");
					// If the number of placed bishops is the number we
					// want, increment the number of solutions and remove the last placed bishop.
					if (placedBishops.size() == numBishops) {
						numPlacements++;
						System.out.println("New Solution! Number of sol: " + numPlacements);
						placedBishops.remove(placedBishops.size() - 1);
						// break;
					} else {
						backtrack(row + 1, n);
					}
				} else {
					System.out.println(row + "," + i + " is not safe.");
				}
			}

			if (placedBishops.size() > 0)
				placedBishops.remove(placedBishops.size() - 1);
		}

	}

}
