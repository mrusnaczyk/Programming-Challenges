// @JUDGE_ID:	859464  10205  Java  "Stack 'Em Up"
package Challenges_II.Stack_Em_Up;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static final String[] CARD_VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",
			"Ace" };
	static final String[] CARD_SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		try {
			int numCases;
			int numShuffle;
			int shuffleNumber;
			int[][] shufflePatterns;
			int[] cardPositions;
			int[] tempCardPositions;
			HashMap<Integer, String> defaultSet = new HashMap<Integer, String>();

			numCases = Integer.parseInt(s.nextLine());

			// Build dictionary of default card set
			int count = 0;
			for (int suit = 0; suit < CARD_SUITS.length; suit++) {
				for (int value = 0; value < CARD_VALUES.length; value++) {
					defaultSet.put(count, CARD_VALUES[value] + " of " + CARD_SUITS[suit]);
					count++;
				}
			}
			s.nextLine();

			for (int cases = 0; cases < numCases; cases++) {
				String shuffleN;
				numShuffle = Integer.parseInt(s.nextLine());
				shufflePatterns = new int[numShuffle][52];
				cardPositions = new int[52];

				// Figure out what the shuffle patterns are and create a new deck
				for (int shuff = 0; shuff < numShuffle; shuff++) {
					for (int card = 0; card < 52; card++) {
						shufflePatterns[shuff][card] = s.nextInt();
						cardPositions[card] = card + 1;
					}
				}

				// fixes bugs related to using nextInt() and nextLine()
				s.nextLine();

				// start shuffling
				while (s.hasNextLine() && !(shuffleN = s.nextLine()).trim().isEmpty()) {
					shuffleNumber = Integer.parseInt(shuffleN) - 1;
					tempCardPositions = new int[52];
					for (int i = 0; i < 52; i++)
						tempCardPositions[i] = cardPositions[shufflePatterns[shuffleNumber][i] - 1];
					cardPositions = tempCardPositions;
				}

				for (int a : cardPositions)
					System.out.println(defaultSet.get(a - 1));
				System.out.println();
			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}

	}
}
