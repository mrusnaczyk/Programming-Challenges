package Challenges_VII.Euclid_Problem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			while (true) {
				String[] next = s.nextLine().split(" ");
				int a = Integer.parseInt(next[0].trim());
				int b = Integer.parseInt(next[1].trim());

				int[] d = gcd(a, b);
				System.out.println(d[0] + " " + d[1] + " " + d[2]);

			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}  
	}

	public static int[] gcd(int a, int b) {
		int[] answer = { 1, 0, a };
		int g = b;

		if (b > 0) {
			int r = a % b;
			int q = a / b;
			answer = gcd(b, r);
			int y1 = answer[0] - answer[1] * q;
			answer[0] = answer[1];
			answer[1] = y1;
			return answer;
		} else {
			return answer;
		}
	}
}
