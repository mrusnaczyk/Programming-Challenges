package Challenges_VII.Carmichael_Numbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static final int MAX = 65001;
	public static HashMap<String,Integer> primeHash;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		primeHash = new HashMap<String, Integer>();
		int next;
		genPrimes();
		
		while((next = s.nextInt()) != 0){
			BigInteger randNum = BigInteger.valueOf((int) (Math.random() * (next - 1)) + 2);
			BigInteger fermatTest = randNum.pow(next).mod(BigInteger.valueOf(next));
			if(fermatTest.equals(randNum) && primeHash.get(String.valueOf(next)) == null){
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
