// @JUDGE_ID: 859464  10105  Java  "Polynomial Coefficients"
package Polynomial_Coefficients;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try {
			while (true) {
				String[] lineOne = s.nextLine().split(" ");
				String[] lineTwo = s.nextLine().split(" ");
				int power = Integer.parseInt(lineOne[0]);
				int numVar = Integer.parseInt(lineOne[1]);
				int[] terms = new int[numVar];

				for (int i = 0; i < numVar; i++) {
					terms[i] = Integer.parseInt(lineTwo[i]);
				}

				// Applying the Multinomial Theorem
				int denominator = 1;
				for (int i : terms) {
					denominator *= factorial(i);
				}

				int sum = factorial(power) / denominator;

				System.out.println(sum);
			}

		} catch (Exception e) {
			s.close();
			System.exit(0);
		}
	}

	static int factorial(int start) {
		int product = start;
		if (start == 0) {
			return 1;
		} else {
			for (int i = start - 1; i > 0; i--)
				product *= i;
			return product;
		}
	}

}
