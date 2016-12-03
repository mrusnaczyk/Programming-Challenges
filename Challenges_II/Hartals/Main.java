// @JUDGE_ID:	859464  10050  Java  "Hartals"
package Challenges_II.Hartals;

import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int numCases = s.nextInt();
		
		for(int z = 0; z < numCases; z++)
		{
			int simulationLength = s.nextInt();
			int numParties = s.nextInt();
			int[] hartalParams = new int[numParties];
			int numHartals = 0;
			
			//collect a hartal parameter for each political party
			for(int i = 0; i < numParties; i++)
				hartalParams[i] = s.nextInt();
			
			for(int day = 1; day <= simulationLength; day++)
			{
				//check if it's Friday or Saturday
				if((day % 7 != 6) && (day % 7 != 0))
				{
					for(int h: hartalParams)
					{
						//check if a Hartal was supposed to occur for each party
						if(day % h == 0)
						{
							numHartals++;
							break;
						}
					}
				}
			}
			
			System.out.println(numHartals);
		}
		s.close();
		System.exit(0);
	}
}