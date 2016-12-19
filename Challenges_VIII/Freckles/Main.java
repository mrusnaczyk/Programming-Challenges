package Challenges_VIII.Freckles;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numCases = s.nextInt();

		for (int cases = 0; cases < numCases; cases++) {
			int numFreckles = s.nextInt();
			double[][] freckles = new double[numFreckles][2];
			int[] frecklesVisited = new int[numFreckles];
			// Read the coordinates of the freckles
			for (int f = 0; f < numFreckles; f++) {
				freckles[f][0] = s.nextDouble();
				freckles[f][1] = s.nextDouble();
			}
			
			frecklesVisited[0] = 1;
			int numLines = 1;
			double totalDist = 0;
			while (numLines < numFreckles) {
				int candidate = 0;		
				double minimum = -1.0;
				
				for (int i = 0; i < numFreckles; i++) {
					if (frecklesVisited[i] == 0){
						continue;
					}
						for (int j = 0; j < numFreckles; j++) {
							if (frecklesVisited[j] != 0){
								continue;
							}
								double dist = Math.sqrt(Math.pow(freckles[i][0] - freckles[j][0], 2) + Math.pow(freckles[i][1] - freckles[j][1], 2));
								if (dist < minimum || minimum == -1.0) {									
									candidate = j;
									minimum = dist;
								}
						}
				}
				
				numLines++;	
				frecklesVisited[candidate] = 1;
				totalDist+= minimum;

			}

			System.out.printf(String.format("%.2f", totalDist));
			System.out.println("");
			s.nextLine();
			if(cases < numCases-1)
				System.out.println("");

		}

		s.close();
		System.exit(0);
	}
}
