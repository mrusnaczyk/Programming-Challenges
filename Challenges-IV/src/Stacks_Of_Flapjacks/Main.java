// @JUDGE_ID: 859464  120  Java  "Stacks of Flapjacks"
package Stacks_Of_Flapjacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			try {
				String originalStack = s.nextLine();
				ArrayList<Integer> workingStack = new ArrayList<Integer>();
				for (String i : originalStack.split(" ")) {
					workingStack.add(Integer.parseInt(i));
				}
				Collections.reverse(workingStack);
				int smallest = Collections.min(workingStack);
				int largest = Collections.max(workingStack);
				int absoluteMax = largest;
				String flips = "";
				/*
				 * 1) Find largest element in the unsorted part of the stack 
				 * 2) Add the index of that element to the list of flips 
				 * 3) Flip the stack from where the element is located to the end of the stack 
				 * 4) Add the new index of the element to the list of flips 
				 * 5) Flip the stack from that index to the end
				 */
				for (int i = 0; !isSorted(workingStack); i++) {
					largest = Collections.max(workingStack.subList(i, workingStack.size()));
					flips += workingStack.indexOf(largest) + 1 + " ";
					Collections.reverse(workingStack.subList(workingStack.indexOf(largest), workingStack.size()));
					flips += i + 1 + " ";
					Collections.reverse(workingStack.subList(i, workingStack.size()));
				}
				System.out.println(originalStack);
				System.out.println(flips + "0");
			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}
	}

	static boolean isSorted(ArrayList<Integer> arr) {
		for (int i = 1; i < arr.size(); i++) {
			if (!(arr.get(i) < arr.get(i - 1)))
				return false;
		}
		return true;
	}
}
