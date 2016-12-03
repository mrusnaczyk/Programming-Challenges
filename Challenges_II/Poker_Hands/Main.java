// @JUDGE_ID:	859464  10315  Java  "Poker Hands"
package Challenges_II.Poker_Hands;

import java.util.*;

public class Main {
	static String[] c = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
	static List<String> cards = Arrays.asList(c);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			try {
				Scanner parseCards;

				String cardSet;
				String[] blackCards = new String[5];
				String[] whiteCards = new String[5];
				int blackPoint = 0;
				int whitePoint = 0;
				boolean whiteHasRank = false;
				boolean blackHasRank = false;

				cardSet = s.nextLine();
				parseCards = new Scanner(cardSet);

				// Separate black and white cards
				for (int i = 0; i < 10; i++) {
					if (i < 5)
						blackCards[i] = parseCards.next();
					else
						whiteCards[i - 5] = parseCards.next();
				}
				parseCards.close();

				int whiteRankTemp;
				int blackRankTemp;

				// Test for a straight flush
				whiteRankTemp = StraightFlush(whiteCards);
				blackRankTemp = StraightFlush(blackCards);

				if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 9;
				} else if (whiteRankTemp > blackRankTemp & !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 9;
				}

				// Test for a Four of a Kind
				blackRankTemp = NOfAKind(blackCards, 4);
				whiteRankTemp = NOfAKind(whiteCards, 4);

				if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 8;
				} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 8;
				}

				// Test for a Full House
				blackRankTemp = FullHouse(blackCards);
				whiteRankTemp = FullHouse(whiteCards);

				if (blackRankTemp != -1 && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 7;
				} else if (whiteRankTemp != -1 && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 7;
				}

				// Test for a Flush
				boolean whiteFlush = Flush(whiteCards);
				boolean blackFlush = Flush(blackCards);

				if (whiteFlush && blackFlush) {
					blackRankTemp = 0;
					whiteRankTemp = 0;
					int exclude = 100; // An arbitrary number
					// find minimum
					int bMin = 15;
					int wMin = 15;
					for (int i = 0; i < 5; i++) {
						if (cards.indexOf(blackCards[i].substring(0, 1)) + 1 < bMin)
							bMin = cards.indexOf(blackCards[i].substring(0, 1)) + 1;

						if (cards.indexOf(whiteCards[i].substring(0, 1)) + 1 < wMin)
							wMin = cards.indexOf(whiteCards[i].substring(0, 1)) + 1;
					}

					while (blackRankTemp == whiteRankTemp && bMin != exclude && wMin != exclude) {
					//while (blackRankTemp == whiteRankTemp) {
						blackRankTemp = HighCard(blackCards, exclude);
						whiteRankTemp = HighCard(whiteCards, exclude);
						exclude = blackRankTemp;
					}
					if (blackRankTemp > whiteRankTemp && !blackHasRank) {
						blackHasRank = true;
						blackPoint = 6;
					} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
						whiteHasRank = true;
						whitePoint = 6;
					}
				}
				if (blackFlush && !whiteFlush && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 6;
				} else if (whiteFlush && !blackFlush && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 6;
				}

				// Test for a Straight
				blackRankTemp = Straight(blackCards);
				whiteRankTemp = Straight(whiteCards);
				if (blackRankTemp != -1 && whiteRankTemp != -1) {
					int exclude = 100; // An arbitrary number
					while (blackRankTemp == whiteRankTemp) {
						blackRankTemp = HighCard(blackCards, exclude);
						whiteRankTemp = HighCard(whiteCards, exclude);
						exclude = blackRankTemp;
					}
				} else if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 5;
				} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 5;
				}

				// Test for a Three of a Kind
				blackRankTemp = NOfAKind(blackCards, 3);
				whiteRankTemp = NOfAKind(whiteCards, 3);

				if (blackRankTemp != -1 && whiteRankTemp != -1) {
					blackRankTemp = HighCard(blackCards, 100);
					whiteRankTemp = HighCard(whiteCards, 100);
				}
				if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 4;
				} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 4;
				}

				// Test for Two Pairs
				blackRankTemp = TwoPairs(blackCards);
				whiteRankTemp = TwoPairs(whiteCards);

				if (blackRankTemp != -1 && whiteRankTemp != -1 && blackRankTemp == whiteRankTemp) {
					int blackRankTemp2 = Pair(blackCards, blackRankTemp);
					int whiteRankTemp2 = Pair(whiteCards, whiteRankTemp);
					int whiteRank3 = 0;
					int blackRank3 = 0;
					if (blackRankTemp2 == whiteRankTemp2) {
						for (int card = 0; card < 5; card++) {
							String wCard = whiteCards[card].substring(0, 1);
							String bCard = blackCards[card].substring(0, 1);

							if (!wCard.equals(cards.get(whiteRankTemp - 1))
									&& !wCard.equals(cards.get(whiteRankTemp2 - 1))) {
								whiteRank3 = cards.indexOf(wCard) + 1;
							}
							if (!bCard.equals(cards.get(blackRankTemp - 1))
									&& !bCard.equals(cards.get(blackRankTemp2 - 1))) {
								blackRank3 = cards.indexOf(bCard) + 1;
							}
						}
						blackRankTemp = blackRank3;
						whiteRankTemp = whiteRank3;

					} else {
						blackRankTemp = blackRankTemp2;
						whiteRankTemp = whiteRankTemp2;
					}
				}

				if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 3;
				} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 3;
				}

				// Test for a Pair
				blackRankTemp = Pair(blackCards, 100);
				whiteRankTemp = Pair(whiteCards, 100);

				if (blackRankTemp != -1 && whiteRankTemp != -1 && blackRankTemp == whiteRankTemp) {
					// int exclude = 100;

					whiteRankTemp = HighCard(whiteCards, 100);
					blackRankTemp = HighCard(blackCards, 100);
					// exclude = blackRankTemp;

				} else if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 2;

				} else if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 2;
				}

				// Test for the highest card

				blackRankTemp = HighCard(blackCards, 100);
				whiteRankTemp = HighCard(whiteCards, 100);

				if (blackRankTemp == whiteRankTemp) {
					// find minimum
					int bMin = 15;
					int wMin = 15;
					for (int i = 0; i < 5; i++) {
						if (cards.indexOf(blackCards[i].substring(0, 1)) + 1 < bMin)
							bMin = cards.indexOf(blackCards[i].substring(0, 1)) + 1;

						if (cards.indexOf(whiteCards[i].substring(0, 1)) + 1 < wMin)
							wMin = cards.indexOf(whiteCards[i].substring(0, 1)) + 1;
					}

					int exclude = 100;
					while (blackRankTemp == whiteRankTemp && bMin != exclude && wMin != exclude) {
						blackRankTemp = HighCard(blackCards, exclude);
						whiteRankTemp = HighCard(whiteCards, exclude);
						exclude = blackRankTemp;
					}

				}
				if (blackRankTemp > whiteRankTemp && !blackHasRank) {
					blackHasRank = true;
					blackPoint = 1;

				}
				if (whiteRankTemp > blackRankTemp && !whiteHasRank) {
					whiteHasRank = true;
					whitePoint = 1;
				}

				if (whitePoint == blackPoint)
					System.out.println("Tie.");
				else if (whitePoint > blackPoint)
					System.out.println("White wins.");
				else if (blackPoint > whitePoint)
					System.out.println("Black wins.");
				else
					System.out.println("Uh oh!");

			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}
	}

	// Return the rank of the next highest card value after the "excluded" card
	static int HighCard(String[] hand, int exclude) {
		int max = -1;

		for (String s : hand) {
			if (cards.indexOf(s.substring(0, 1)) + 1 > max && cards.indexOf(s.substring(0, 1)) + 1 < exclude)
				max = cards.indexOf(s.substring(0, 1)) + 1;
		}
		return max;
	}

	// Return the rank of the card that has a pair
	static int Pair(String[] hand, int exclude) {
		boolean pairFound = false;
		int indexOfPair = -1;

		for (int i = 0; i < hand.length; i++) {
			String s = hand[i].substring(0, 1);
			for (int j = 0; j < hand.length; j++) {
				// We only want to check the value of the card, not the suit
				String t = hand[j].substring(0, 1);
				if (exclude == 100 || !s.equals(cards.get(exclude - 1))) {
					if (s.equals(t) && j != i) {
						indexOfPair = cards.indexOf(t) + 1;
						pairFound = true;
						break;
					}
				}
			}
			if (pairFound)
				break;
		}
		return indexOfPair;
	}

	// Return the rank of the highest value of the two *distinct* pairs
	static int TwoPairs(String[] hand) {
		int numPairs = 0;
		String skip = "";
		int indexOfPair = -1;

		for (int i = 0; i < hand.length; i++) {
			String s = hand[i].substring(0, 1);
			for (int j = 0; j < hand.length; j++) {
				String t = hand[j].substring(0, 1);

				if (s.equals(t) && !s.equals(skip) && j != i) {
					if (cards.indexOf(t) + 1 > indexOfPair)
						indexOfPair = cards.indexOf(t) + 1;
					skip = t;
					numPairs++;
					break;
				}
			}
			if (numPairs == 2)
				return indexOfPair;
		}
		return -1;
	}

	// Returns the rank of the 'n' consecutive cards found
	static int NOfAKind(String[] hand, int num) {
		int numFound;
		int indexOfTriple = -1;

		for (int i = 0; i < hand.length; i++) {
			String s = hand[i].substring(0, 1);
			numFound = 0;
			for (int j = 0; j < hand.length; j++) {
				String t = hand[j].substring(0, 1);
				if (s.equals(t) && j != i) {
					numFound++;
					indexOfTriple = cards.indexOf(t) + 1;
				}

				if (numFound == num - 1)
					return indexOfTriple;
			}
		}
		return -1;
	}

	static int Straight(String[] hand) {
		int max = -1;

		for (int i = 1; i < hand.length; i++) {
			int t = cards.indexOf(hand[i].substring(0, 1)) + 1;
			int s = cards.indexOf(hand[i - 1].substring(0, 1)) + 1;
			if (t == s + 1)
				max = t;
			else
				return -1;
		}
		return max;
	}

	static boolean Flush(String[] hand) {
		for (int i = 1; i < hand.length; i++) {
			String t = hand[i].substring(1);
			String s = hand[i - 1].substring(1);
			if (!t.equals(s))
				return false;
		}
		return true;
	}

	static int FullHouse(String[] hand) {
		int tripeCardRank = NOfAKind(hand, 3);
		int pair;
		String[] remainingCards = {"0C", "0C"};

		if (tripeCardRank != -1) {
			int count = 0;
			for (int i = 0; i < 5; i++) {
				String card = hand[i];
				if (!card.substring(0, 1).equals(cards.get(tripeCardRank - 1))) {
					remainingCards[count] = card;
					count++;
				}
			}

			pair = Pair(remainingCards, 100);

			if (pair != -1)
				return tripeCardRank;
		}
		return -1;
	}

	static int StraightFlush(String[] hand) {
		int straight = Straight(hand);
		if (Flush(hand) && straight != -1)
			return straight;
		else
			return -1;
	}

}
