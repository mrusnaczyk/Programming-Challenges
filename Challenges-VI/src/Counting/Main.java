// @JUDGE_ID: 859464  10198  Java  "Counting"
package Counting;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<BigInteger> perms = new ArrayList<BigInteger>();
	static int length = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		perms.add(BigInteger.valueOf(2));
		perms.add(BigInteger.valueOf(5));
		perms.add(BigInteger.valueOf(13));

		for (int i = 3; i < 1000; i++) {
			BigInteger a = perms.get(i - 1).multiply(BigInteger.valueOf(2));
			a = a.add(perms.get(i - 2));
			a = a.add(perms.get(i - 3));

			perms.add(a);
		}

		try {
			while (true) {
				int n = Integer.parseInt(s.nextLine().trim());
				System.out.println(perms.get(n - 1));
			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}
	}
}
