package Challenges_VII.Light_More_Light;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long next = 0;
		
		while ((next = s.nextLong()) != 0) {
			long sqrt = (long) Math.sqrt(next);
			if (Math.pow(sqrt, 2) == next)
				System.out.println("yes");
			else
				System.out.println("no");
		}
		s.close();
		System.exit(0);

	}

}
