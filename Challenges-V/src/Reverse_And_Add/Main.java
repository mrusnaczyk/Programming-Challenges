// @JUDGE_ID: 859464  10018  Java  "Reverse and Add"
package Reverse_And_Add;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try {
			int numCases = Integer.parseInt(s.nextLine());
			for (int cases = 0; cases < numCases; cases++) {
				Long num = Long.parseLong(s.nextLine());
				Long sum = null;
				int numIterations = 0;

				while (true) {
					numIterations++;
					sum = num + reverse(num);
					num = sum;
					if ((num.toString()).equals(reverse(num).toString()))
						break;
				}
				System.out.println(numIterations + " " + sum);

			}

		} catch (Exception e) {
			s.close();
			System.exit(0);
		}

	}

	static Long reverse(long num) {
		char[] org = ((Long) num).toString().toCharArray();
		char[] rev = new char[org.length];

		for (int i = 0; i < org.length; i++) {
			int reversePosition = org.length - 1 - i;
			rev[reversePosition] = org[i];
		}
		return Long.parseLong(String.valueOf(rev));
	}

}
