// @JUDGE_ID: 859464  10035  Java  "Primary Arithmetic"
package Challenges_V.Primary_Arithmetic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String padding = "00000000000";
		String nextLine;

		while (!(nextLine = s.nextLine()).equals("0 0")) {
			int spaceIndex = nextLine.indexOf(" ");
			String numOneUnpadded = nextLine.substring(0, spaceIndex);
			String numTwoUnpadded = nextLine.substring(spaceIndex + 1);

			String[] numOne = (padding.substring(numOneUnpadded.length()) + numOneUnpadded).split("");
			String[] numTwo = (padding.substring(numTwoUnpadded.length()) + numTwoUnpadded).split("");

			int numCarry = 0;

			for (int i = 10; i > 0; i--) {
				int a = Integer.parseInt(numOne[i]);
				int b = Integer.parseInt(numTwo[i]);
				if (a + b > 9) {
					numOne[i - 1] = ((Integer) (Integer.parseInt(numOne[i - 1]) + 1)).toString();
					numCarry++;
				}
			}

			if (numCarry == 0) {
				System.out.println("No carry operation.");
			} else if (numCarry == 1) {
				System.out.println("1 carry operation.");
			} else {
				System.out.println(numCarry + " carry operations.");
			}

		}
		s.close();

	}

}
