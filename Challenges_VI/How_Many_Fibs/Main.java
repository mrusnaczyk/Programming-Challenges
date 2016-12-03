// @JUDGE_ID: 859464  10183  Java  "How Many Fibs?"
package Challenges_VI.How_Many_Fibs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<BigInteger> fibs = generateFibs();
		
		while (true){
			int numFib = 0;
			BigInteger start = s.nextBigInteger();
			BigInteger end = s.nextBigInteger();
			
			if(start.equals(BigInteger.ZERO) && end.equals(BigInteger.ZERO)){
				s.close();
				System.exit(0);
			}else if(start.compareTo(end) > 0){
				start = end;
			}
			
			for(BigInteger a : fibs){
				if(a.compareTo(start) >= 0 && a.compareTo(end) <= 0)
					numFib++;
			}
			
			System.out.println(numFib);
		}
	}
	public static ArrayList<BigInteger> generateFibs() {
		ArrayList<BigInteger> f = new ArrayList<BigInteger>();
		f.add(BigInteger.valueOf(1));
		f.add(BigInteger.valueOf(2));
		
		for (int i = 2; i <= 500; i++)
			f.add(f.get(i-1).add(f.get(i-2)));
		
		return f;
	}
}
