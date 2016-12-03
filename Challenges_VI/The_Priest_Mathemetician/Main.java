// @JUDGE_ID: 859464  10254  Java  "The Priest Mathematician"
package Challenges_VI.The_Priest_Mathemetician;

import java.math.BigInteger; 
import java.util.ArrayList;
import java.util.Scanner; 

public class Main { 
	static ArrayList<BigInteger> moves = new ArrayList<BigInteger>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		genMoves();

		try {
			while (true) {
				int n = Integer.parseInt(s.nextLine().trim());
				System.out.println(moves.get(n));
			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}

	}

	public static void genMoves() {
		int count = 2;
		int exp = 1;

		moves.add(BigInteger.ZERO);
		moves.add(BigInteger.ONE);
		int countCurrent = 0;

		for (int i = 2; i <= 10000; i++) {

			BigInteger lastMove = moves.get(i - 1);
			moves.add(lastMove.add(BigInteger.valueOf(2).pow(exp)));
			countCurrent++;

			if (countCurrent == count) {
				countCurrent = 0;
				count++;
				exp++;
			}
		}
	}
}
