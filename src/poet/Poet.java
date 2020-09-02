package poet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Poet {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		List<String> input = Files.readAllLines(Paths.get("src/poet/" + in.nextLine()));
		int[] code = new int[(input.get(input.size() - 1).length() + 1) / 5];
		String ans = "";
		String[][] lines = new String[99][99];
		for (int i = 0; i < input.size() - 1; i++) {
			for (int y = 0; y < input.get(i).split(" ").length; y++) {
				lines[i][y] = input.get(i).split(" ")[y];
			}
		}
		for(int i =0;i<input.get(input.size()-1).split(" ").length;i++) {
			code[i] = Integer.parseInt(input.get(input.size()-1).split(" ")[i]);
		}
		for (int x : code) {
			ans += "" + lines[(x / 100)-1][(x/10 % 10)-1].charAt((x % 10) - 1);
		}
		System.out.println("Message: " + ans);
	}
}
