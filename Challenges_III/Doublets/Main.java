// @JUDGE_ID: 859464  10150  Java  "Doublets"
package Challenges_III.Doublets;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<String> dictionary = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Get dictionary of words from input
		String input;
		while (!(input = s.nextLine()).equals("")) {
			dictionary.add(input);
		}

		// Parse pairs of words and find the sequence that connects them
		while (true) {
			try {
				input = s.nextLine();
				String[] pair = input.split(" ");
				ArrayList<String> sequence = new ArrayList<String>();
				int numberDifferences = numLetterDifferences(pair[0].toCharArray(), pair[1].toCharArray());

				String currentWord = pair[0];
				sequence.add(pair[0]);
				while (numberDifferences > 0) {
					currentWord = findNextDoublet(currentWord, pair[1], numberDifferences);
					if (currentWord == null) {
						break;
					} else {
						sequence.add(currentWord);
						numberDifferences--;
					}
				}

				if (currentWord != null) {
					for (String a : sequence) {
						System.out.println(a);
					}
					// System.out.println();
				} else {
					System.out.println("No solution.");
				}
				System.out.println();

			} catch (Exception e) {
				// System.out.println(e.getMessage());
				s.close();
				System.exit(0);
			}
		}

	}

	private static String findNextDoublet(String a, String b, int numDiffTotal) {
		for (String s : dictionary) {
			int numDiffA = numLetterDifferences(s.toCharArray(), a.toCharArray());
			int numDiffB = numLetterDifferences(s.toCharArray(), b.toCharArray());

			// Returns word only if it is a doublet and is one letter closer to
			// the target
			if (numDiffA == 1 && numDiffB == numDiffTotal - 1) {
				return s;
			}
		}
		return null;
	}

	private static int numLetterDifferences(char[] a, char[] b) {
		char[] wordA = new char[16];
		char[] wordB = new char[16];
		// This eliminates the chance of a indexOutOfBounds error
		for (int i = 0; i < a.length; i++)
			wordA[i] = a[i];
		for (int i = 0; i < b.length; i++)
			wordB[i] = b[i];

		int numDifferences = 0;
		for (int i = 0; i < 16; i++) {
			if (wordA[i] != wordB[i]) {
				numDifferences++;
			}
		}

		return numDifferences;
	}

}
