// @JUDGE_ID: 859464  10191  Java  "Longest Nap"
package Longest_Nap;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DecimalFormat minutes = new DecimalFormat("00");
		int numDays = 1;

		while (true) {
			try {
				int numAppts = Integer.parseInt(s.nextLine());
				ArrayList<Integer> appts = new ArrayList<Integer>();
				// Parse the professor's schedule, converting start and end
				// times to minutes
				for (int appt = 0; appt < numAppts; appt++) {
					String next = s.nextLine();
					int hourStart = Integer.parseInt(next.substring(0, 2));
					int minStart = Integer.parseInt(next.substring(3, 5));
					int hourEnd = Integer.parseInt(next.substring(6, 8));
					int minEnd = Integer.parseInt(next.substring(9, 11));

					appts.add(hourStart * 60 + minStart);
					appts.add(hourEnd * 60 + minEnd);
				}
				// append 10:00 and 18:00 to the list
				appts.add(0, 60 * 10);
				appts.add(18 * 60);

				// The schedule may not be in chronological order, so sorting is
				// necessary
				Collections.sort(appts);

				// find how long a possible nap will be
				ArrayList<Integer> possibleNaps = new ArrayList<Integer>();
				for (int i = 0; i < appts.size() - 1; i += 2) {
					possibleNaps.add(appts.get(i + 1) - appts.get(i));
				}

				int longestNap = Collections.max(possibleNaps);
				int longestNapStart = appts.get(possibleNaps.indexOf(longestNap) * 2);

				if (longestNap >= 60) {
					System.out.println("Day #" + numDays + ": the longest nap starts at " + longestNapStart / 60 + ":"
							+ minutes.format(longestNapStart % 60) + " and will last for " + longestNap / 60
							+ " hours and " + longestNap % 60 + " minutes.");
				} else {
					System.out.println("Day #" + numDays + ": the longest nap starts at " + longestNapStart / 60 + ":"
							+ minutes.format(longestNapStart % 60) + " and will last for " + longestNap + " minutes.");
				}
				numDays++;

			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}

	}

}
