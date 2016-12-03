// @JUDGE_ID: 859464  10127  Java  "Ones"
package Ones;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try {
			while (true) {
				int n = Integer.parseInt(s.nextLine());
				int numDigits = 1;
				long multiple = 1;

				while ((multiple % n) != 0) {
					numDigits++;
					multiple = (multiple*10 + 1)%n;
				}
				System.out.println(numDigits);
			}

		} catch (Exception e) {
			s.close();
			System.exit(0);
		}
	}
}
