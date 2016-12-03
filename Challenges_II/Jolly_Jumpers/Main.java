// @JUDGE_ID:	859464  10038  Java  "Jolly Jumpers"
package Challenges_II.Jolly_Jumpers;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			try {
				int[] set = new int[s.nextInt()];
				boolean[] jumper = new boolean[set.length];
				jumper[0] = true;
				boolean nonJumper = false;

				// populate array
				for (int i = 0; i < set.length; i++)
					set[i] = s.nextInt();

				// check if absolute difference between two consecutive numbers is in between 0 and n-1
				for (int i = 1; i < set.length; i++) {
					int diff = Math.abs(set[i] - set[i - 1]);
					if (diff > 0 && diff < set.length)
						jumper[diff] = true;
				}

				// check to make sure every number was found
				for (boolean b : jumper) {
					if (!b) {
						nonJumper = true;
						break;
					}
				}

				if (nonJumper)
					System.out.println("Not jolly");
				else
					System.out.println("Jolly");

			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}
	}
}
