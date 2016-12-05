package Challenges_VII.Summation_Of_Four_Primes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> primeList;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		primeList = new ArrayList<Integer>();
		genPrimes();
		try{
			while (true) {
				String primes = "";
				int next = Integer.parseInt(s.nextLine().trim());
				if (next > 8) {
					if ((next - 4) % 2 == 0) {
						next -= 4;
						primes += "2 2 ";
					} else {
						next -= 5;
						primes += "2 3 ";
					}
	
					for (int p : primeList) {
						if (primeList.contains(next - p)) {
							primes += p + " " + primeList.get(primeList.indexOf(next - p));
							break;
						}
					}
	
				} else {
					int temp = 0;
					while (temp != next) {
						temp += 2;
						primes += "2 ";
					}
				}
				System.out.println(primes.trim());
			}
		}catch(Exception e){
			s.close();
			System.exit(0);
		}

	}

	public static void genPrimes() {
		primeList.add(2);
		for (int i = 3; i < 1000000; i++) {
			if (i % 2 != 0) {
				int rootX = (int) Math.sqrt(i);
				boolean divisible = false;
				for (int j = 2; j < rootX + 1; j++) {
					if (i % j == 0) {
						divisible = true;
						break;
					}
				}
				if (!divisible) {
					primeList.add(i);
				}

			}
		}
	}

}
