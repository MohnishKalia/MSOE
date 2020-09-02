package prob5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class Prob5 {
	public static void main(String[] args) throws IOException {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Filepath Name:");
			List<String> lines = Files.readAllLines(Paths.get(input.nextLine()));
			
			int[][] nums = lines.stream().map(line -> Stream.of(line.split("[ ]+")).filter(s -> ! s.equals("")).mapToInt(Integer::parseInt).toArray())
					.toArray(int[][]::new);

			List<NumberTuple> tuples = new ArrayList<>();

			// vertical
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = 0; j < nums[0].length; j++) {
					int n1 = nums[i][j], n2 = nums[i + 1][j], n3 = nums[i + 2][j];
					if (is13(n1, n2, n3))
						tuples.add(new NumberTuple(n1, n2, n3));
				}
			}

			// horizontal
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums[0].length - 2; j++) {
					int n1 = nums[i][j], n2 = nums[i][j + 1], n3 = nums[i][j + 2];

					if (is13(n1, n2, n3))
						tuples.add(new NumberTuple(n1, n2, n3));
				}
			}

			for (NumberTuple tuple : tuples)
				System.out.println(tuple);
		}
	}

	public static boolean is13(int a, int b, int c) {
		return a + b + c == 13;
	}
}

class NumberTuple {
	private int a, b, c;

	public NumberTuple(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String toString() {
		int[] nums = { a, b, c };
		Arrays.sort(nums);
		return String.format("%d, %d, %d", nums[0], nums[1], nums[2]);
	}
}
