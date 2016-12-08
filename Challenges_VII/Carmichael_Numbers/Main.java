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

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static final int MAX = 65001;
	public static HashMap<String,Integer> primeHash;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		primeHash = new HashMap<String, Integer>();
		BigInteger next;
		genPrimes();
		
		while(!(next = s.nextBigInteger()).equals(BigInteger.ZERO)){
			//BigInteger randNum = BigInteger.valueOf((int) (Math.random() * (next - 1)) + 2);
			//BigInteger fermatTest = randNum.pow(next).mod(BigInteger.valueOf(next));
			if( next.isProbablePrime(100) && primeHash.get(String.valueOf(next)) == null){
				System.out.println("The number " + next + " is a Carmichael number.");
			}else{
				System.out.println(next + " is normal.");
			}
		}
		s.close();
		System.exit(0);

	}
	
	
	public static void genPrimes(){
		
	    boolean[] sieve = new boolean[MAX+1]; 
	    sieve[0] = true; 
	    sieve[1] = true; 
	    sieve[2] = false;

	    for(int i = 4; i <= MAX; i+=2)
	    	sieve[i] = true;
	    
	    for(int i = 3; i < (int)Math.sqrt(MAX)+1; i+=2)
	    {
	        if(!sieve[i])
	        {
	            for(int j = i*i; j <= MAX; j+=i)
	            	sieve[j] = true;
	        }
	    }
	    
	    for(int b = 0; b < sieve.length; b++){
	    	if(!sieve[b]){
	    		primeHash.put(String.valueOf(b), b);
	    	}
	    }

	}

}
