package Challenges_VIII.Little_Bishops;

import java.util.Scanner;

public class Main {
	static int numPlacements;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sizeOfBoard = 0;
		int numBishops = 0;

		while (true) {
			sizeOfBoard = s.nextInt();
			numBishops = s.nextInt();
			if (sizeOfBoard == 0 && numBishops == 0) {
				s.close();
				System.exit(0);
			}
			
			int totalPlacements = 0;
			boolean[] white, black;

			//Split board into white and black tiles
			if (sizeOfBoard % 2 == 0) {
				white = new boolean[sizeOfBoard - 1];
				black = new boolean[sizeOfBoard];
			} else {
				white = new boolean[sizeOfBoard];
				black = new boolean[sizeOfBoard - 1];
			}
			for (int i = 0; i < numBishops + 1; i++) {
				numPlacements = 0;
				backtrack(white, black, i, 1);
				int a = numPlacements;
				
				numPlacements = 0;
				backtrack(white, black, numBishops - i, 0);
				int b = numPlacements;
				
				totalPlacements += a * b;
			}

			System.out.println(totalPlacements);
			
		}

	}

	static void backtrack(boolean[] white, boolean[] black, int k, int c) {
		if (k == 0) {
			numPlacements++;
			return;
		}
		
		int blackMiddle = (black.length - 1) / 2;
		int whiteMiddle = (white.length) / 2;
		int boardSize = white.length + black.length;

		for (int i = c; i < boardSize - k + 1; i += 2) {
			int temp = i;
			if (temp > (boardSize/2)) {
				temp = (boardSize - temp - 1);
			}
			temp /= 2;

			/*
			 * 1)Check if bishop is already placed
			 * 2)Place the bishop
			 * 3)Continue searching
			 * 4)Remove bishop after all possible combinations have been exhausted
			 */
			int newStart;
			int newEnd;
			
			if (i % 2 == 0) {
				newStart = whiteMiddle - temp;
				newEnd = whiteMiddle + temp + 1;
				for (int j = newStart; j < newEnd; j++) {
					if (!white[j]) {
						white[j] = true;
						backtrack(white, black, k - 1, i + 2);
						white[j] = false;
					}
				}
			} else {
				newStart = blackMiddle - temp;
				newEnd = blackMiddle + temp + 2;
				for (int j = newStart; j < newEnd; j++) {
					if (!black[j]) {
						black[j] = true;
						backtrack(white, black, k - 1, i + 2);
						black[j] = false;
					}
				}
			}
		}
	}
}
