// @JUDGE_ID: 859464  10252  Java  "Common Permutation"
package Common_Permutation;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				String common = "";
				char[] A = s.nextLine().toCharArray();
				char[] B = s.nextLine().toCharArray();
				Arrays.sort(A);
				Arrays.sort(B);
				for (char a : A) {
					for (int b = 0; b < B.length; b++) {
						if (a == B[b]) {
							common += a;
							break;
						}
					}
				}
				System.out.println(common);
			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}
	}
}