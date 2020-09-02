package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("First Letter:");
			String l1 = input.nextLine();
			System.out.println("Second Letter:");
			String l2 = input.nextLine();
			System.out.println("Sentence:");
			String sen = input.nextLine();
			int count = 0;
			for (int i = 0; i < sen.length() - 1; i++) {
				if (("" + sen.charAt(i) + sen.charAt(i + 1)).equals(l1 + l2)
						|| ("" + sen.charAt(i) + sen.charAt(i + 1)).equals(l2 + l1)) {
					count++;
				}
			}
			System.out.println("Count: " + count);
			// their fields are in the hidden foreign forest
		}
	}
}
