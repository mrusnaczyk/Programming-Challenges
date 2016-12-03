// @JUDGE_ID: 859464  10082  Java  "WERTYU"
package Challenges_III.WERTYU;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static final String[] Keys = { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "Q", "W", "E", "R",
			"T", "Y", "U", "I", "O", "P", "[", "]", "\\", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Z",
			"X", "C", "V", "B", "N", "M", ",", ".", "/" };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<Integer, String> keyboard = new HashMap<Integer, String>();
		HashMap<String, Integer> keyboardKeyLookup = new HashMap<String, Integer>();

		for (int i = 0; i < Keys.length; i++) {
			keyboard.put(i, Keys[i]);
			keyboardKeyLookup.put(Keys[i], i);
		}
		while (true) {
			try {
				String input = s.nextLine();
				String decodedText = "";
				for (char c : input.toCharArray()) {
					if (Character.isSpaceChar(c)) {
						decodedText += " ";
					} else {
						decodedText += keyboard.get(keyboardKeyLookup.get(Character.toString(c)) - 1);
					}
				}
				System.out.println(decodedText);
			} catch (Exception e) {
				s.close();
				System.exit(0);
			}
		}

	}

}
