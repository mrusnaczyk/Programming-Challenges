package Challenges_VIII.Bicoloring;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int numVertices;
		int numEdges;
		int[][] edges;
		int[] colors;
		
		while ((numVertices = s.nextInt()) != 0) {

				numEdges = s.nextInt();
				edges = new int[numVertices][numVertices];
				colors = new int[numVertices];

				for (int i = 0; i < numEdges; i++) {
					int a = s.nextInt();
					int b = s.nextInt();

					edges[a][b] = 1;
					edges[b][a] = 1;
				}

				if (isColorable(colors, edges)) {
					System.out.println("BICOLORABLE.");
				} else {
					System.out.println("NOT BICOLORABLE.");
				}
			}

	}

	private static boolean isColorable(int[] colors, int[][] edges) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);

		while (!q.isEmpty()) {
			int curr = q.remove().intValue();

			if (colors[curr] == 0)
				colors[curr] = 1;

			int currentColor = colors[curr];

			for (int i = 0; i < edges[curr].length; i++) {
				if (edges[curr][i] == 1) {
					if (colors[i] == currentColor) {
						return false;
					} else if (colors[i] == 0) {
						if(currentColor == 1)
							colors[i] = 2;
						else
							colors[i] = 1;
						q.add(i);
					}
				}
			}
		}

		return true;
	}

}