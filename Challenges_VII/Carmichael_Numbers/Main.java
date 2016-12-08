package Challenges_VII.Carmichael_Numbers;

import java.util.Scanner;

public class Main {

	public static final int MAX = 65001;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int next;

		while ((next = s.nextInt()) != 0) {
			boolean isCar = true;
	        if (checkPrime(next))
	        	isCar = false;
	        else{
		        //check a^b mod b for every value from 2 to 'next' 
		        for (int i = 2; i < next; i++) {
		            if (powerMod(i, next, next) != i) {
		            	isCar = false;
		            	break;
		            }
		        }
	        }
	        
			if (isCar)
				System.out.println("The number " + next + " is a Carmichael number.");
			else
				System.out.println(next + " is normal.");
		}

		s.close();
		System.exit(0);

	}

    public static boolean checkPrime(int num) {
        if (num % 2 == 0) 
            return false;
        
        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }

    
    public static int powerMod(long a, long b, long m) {
        long result = 1;
        while(b > 0) {
            if (b % 2 == 1)
                result = (result * a) % m;
            
            b /= 2;
            a = (a * a) % m;
        }
        return (int) result;
    }


}
