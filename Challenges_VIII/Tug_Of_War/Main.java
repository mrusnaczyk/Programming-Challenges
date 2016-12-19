package Challenges_VIII.Tug_Of_War;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	    int numCases = s.nextInt();
	    
	    for(int cases = 0; cases < numCases; cases++){
            int numPeople = s.nextInt();
            int[] weights = new int[numPeople];
            
            int loop = numPeople / 2 + 1;
            int totalWeight = 0;
            
            
            for (int i = 0; i < numPeople; i++) {
                weights[i] = s.nextInt();
                totalWeight += weights[i];
            }
            
            long[] gameRope = new long[totalWeight + 1];
            gameRope[0] = 1L;
            
            for (int i = 0; i < numPeople; i++){
                for (int j = totalWeight; j >= weights[i]; j--){
                    gameRope[j] = gameRope[j] | ((gameRope[j - weights[i]]) << 1);
                }
            }
            
            int min = 0;
            int max = Integer.MAX_VALUE;
            
            for (int i = 0; i < gameRope.length; i++) {
                for (int j = 0; j <= loop; j++) {
                    if ((gameRope[i] & (1L << j)) != 0L && Math.abs(2 * j - numPeople) <= 1) {
                        if (Math.abs(totalWeight - 2 * i) < max - min) {
                            max = Math.max(totalWeight - i, i);
                            min = Math.min(totalWeight - i, i);
                        }
                    }
                }
            }
 
            System.out.println(min + " " + max);
            if (cases < numCases-1)
                System.out.println();
        }
	    
	    s.close();
	    System.exit(0);
    }
}
