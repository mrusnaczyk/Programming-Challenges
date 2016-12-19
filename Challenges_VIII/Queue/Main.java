package Challenges_VIII.Queue;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//Pre-generate queues
		int[][][] masterQueue = new int[14][14][14];
		masterQueue[1][1][1] = 1;

		for (int i = 2; i <= 13; i++)
			for (int j = 1; j <= i; j++)
				for (int k = 1; k <= (i - j + 1); k++) 
					masterQueue[i][j][k] = (masterQueue[i - 1][j - 1][k]) + (masterQueue[i - 1][j][k - 1]) + ((i - 2) * masterQueue[i - 1][j][k]);
		
		
		int numCases = s.nextInt();
		for (int i = 0; i < numCases; i++) {
			int numPeople = s.nextInt();
			int visibleLeft = s.nextInt();
			int visibleRight = s.nextInt();

			int numPerms = 0;
			if (visibleLeft <= 13 && visibleRight <= 13)
				numPerms = masterQueue[numPeople][visibleLeft][visibleRight];

			System.out.println(numPerms);
		}

	}
}
