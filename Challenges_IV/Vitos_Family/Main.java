// @JUDGE_ID: 859464  10041  Java  "Vito's Family"
package Challenges_IV.Vitos_Family;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int numCases = s.nextInt();

		for (int cases = 0; cases < numCases; cases++) {

			int[] houseNums = new int[s.nextInt()];
			int median = 0;
			for (int i = 0; i < houseNums.length; i++)
				houseNums[i] = s.nextInt();

			Arrays.sort(houseNums);
			median = houseNums[houseNums.length / 2];

			int totalDist = 0;
			for (int i = 0; i < houseNums.length; i++)
				totalDist += Math.abs(houseNums[i] - median);

			System.out.println(totalDist);
		}
		s.close();
		System.exit(0);

	}
}
