// @JUDGE_ID: 859464  10132  Java  "File Fragmentation"
package File_Fragmentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			int numCases = Integer.parseInt(s.nextLine());
			s.nextLine();
			for (int cases = 0; cases < numCases; cases++) {
				ArrayList<String> fragments = new ArrayList<String>();
				int bitCount = 0;
				String next = "";
				while (!(next = s.nextLine()).isEmpty()) {
					fragments.add(next);
					bitCount += next.length();
				}
				int fileBitCount = bitCount / (fragments.size() / 2);
				ArrayList<String> possibleSolutions = new ArrayList<String>();
				for (String a : fragments) {
					//boolean solutionFound = false;
					for (String b : fragments) {
						if ((a + b).length() == fileBitCount) {
							if (checkPattern(a + b, fragments) == (fragments.size() / 2)) {
								possibleSolutions.add(a + b);
							}
						}
					}
				}
				Collections.sort(possibleSolutions);
				System.out.println(possibleSolutions.get(0));
				System.out.println();

			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}
	}

	@SuppressWarnings("unchecked")
	static int checkPattern(String pattern, ArrayList<String> f) {

		ArrayList<String> fragments = (ArrayList<String>) f.clone();
		int numMatches = 0;
		for (int i = 0; i < fragments.size(); i++) {
			String fragA = fragments.get(i);
			for (int j = 0; j < fragments.size(); j++) {
				String fragB = fragments.get(j);
				if (i != j && ((fragA + fragB).equals(pattern) || (fragB + fragA).equals(pattern))) {
					numMatches++;
					fragments.set(i, "*");
					fragments.set(j, "*");
				}
			}
		}

		return numMatches;
	}
}
