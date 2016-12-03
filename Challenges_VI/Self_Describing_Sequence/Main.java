// @JUDGE_ID: 859464  10049  Java  "Self-Describing Sequence"
package Challenges_VI.Self_Describing_Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> GolombSeq = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a;

		genSequence();

		while ((a = s.nextInt()) != 0) {

			int gOfN = Arrays.binarySearch(GolombSeq.toArray(), a);
			if (gOfN >= 0)
				System.out.println(gOfN + 1);
			else
				System.out.println((-gOfN) - 1);

		}
		s.close();
		System.exit(0);

	}

	public static void genSequence() {
		GolombSeq.add(1);
		GolombSeq.add(2);

		int a = 2;
		int b = 2;
		while (GolombSeq.get(GolombSeq.size() - 1) < 2000000000) {
			for (int i = 0; i < b; i++)
				GolombSeq.add(GolombSeq.get(GolombSeq.size() - 1) + a);
			a++;
			if (GolombSeq.get(b) == a)
				b++;
		}
	}
}
