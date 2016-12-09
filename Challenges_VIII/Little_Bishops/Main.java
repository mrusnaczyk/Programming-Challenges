package Challenges_VIII.Little_Bishops;

import java.util.Scanner;

public class Main {

	public static int numSolutions = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int boardSize = 0;
		int maxBishops = 0;

		while ((boardSize = s.nextInt()) != 0 && (maxBishops = s.nextInt()) != 0) {
			numSolutions = 0;
			int[] equations = new int[maxBishops];
			backtrack(equations, 1, maxBishops, boardSize);

			System.out.println(numSolutions);
		}

	}

	public static void backtrack(int[] equations, int numBishops, int maxBishops, int boardSize) {
		if (numBishops < maxBishops) {
			for (int x = 0; x < boardSize; x++) {
				for (int y = 0; y < boardSize; y++) {
					boolean blocked = false;
					for (int e : equations) {
						if (((-1 * x) + e) == y || (x - e) == y) {
							blocked = true;
							break;
						}
					}

					if (!blocked) {
						if (numBishops < maxBishops) {
							int[] temp = equations;
							temp[numBishops] = y - x;
							backtrack(temp, numBishops + 1, maxBishops, boardSize);
						}
						// if (numBishops == maxBishops) {
						// numSolutions++;
						// }
					}
				}
			}
		} else {
			numSolutions++;

		}

	}

}
