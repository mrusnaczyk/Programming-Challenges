package Challenges_VII.Summation_Of_Four_Primes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> primeList;
	public static HashMap<String, Integer> primeHash;
	public static final int MAX = 10000000;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		primeList = new ArrayList<Integer>();
		primeHash = new HashMap<String,Integer>();
		genPrimes();		
		try {
			while (true) {
				String primes = "";
				int next = Integer.parseInt(s.nextLine().trim());
				if (next >= 8) {
					if ((next - 4) % 2 == 0) {
						next -= 4;
						primes += "2 2 ";
					} else {
						next -= 5;
						primes += "2 3 ";
					}

					for (int p : primeList) {
						int potential = next - p;
						if (primeHash.get(String.valueOf(potential)) != null) {
							primes += p + " " + potential;
							break;
						}
					}
					System.out.println(primes.trim());

				} else {
					System.out.println("Impossible.");
				}
				
			}
		} catch (Exception e) {
			s.close();
			System.exit(0);
		}

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
	    		primeList.add(b);
	    		primeHash.put(String.valueOf(b), b);
	    	}
	    }

	}
}
