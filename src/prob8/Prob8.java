package prob8;

import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Prob8 {
	public static void main(String[] args) throws IOException {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Filepath Name:");
			List<String> lines = Files.readAllLines(Paths.get(input.nextLine()));

			int[][] nums = lines.stream()
					.map(line -> Stream.of(line.split("[ ]+")).mapToInt(Integer::parseInt).toArray())
					.toArray(int[][]::new);

			List<NumberTuple> tuples = new ArrayList<>();

			// vertical
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = 0; j < nums[0].length; j++) {
					List<Integer> currentNums = new ArrayList<>();
					int count = 1;
					currentNums.add(nums[i][j]);
					while (count < nums.length) {
						currentNums.add(nums[i + count][j]);
						if (!is99(currentNums))
							continue;
						if (is99(currentNums))
							tuples.add(new NumberTuple(currentNums.toArray(new Integer[currentNums.size()])));
						count++;
					}
				}
			}

			// horizontal
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < nums[0].length - 2; j++) {
//					int n1 = nums[i][j], n2 = nums[i][j + 1], n3 = nums[i][j + 2];
//
//					if (is99(n1, n2, n3))
//						tuples.add(new NumberTuple(n1, n2, n3));
//				}
//			}

			for (NumberTuple tuple : tuples)
				System.out.println(tuple);
		}
	}

	public static boolean is99(List<Integer> a) {
		int count = 0;
		for (int num : a)
			count += num;
		return count == 99;
	}
}

class NumberTuple {
	private Integer[] nums;

	public NumberTuple(Integer... a) {
		nums = a;
	}

	public String toString() {
		List<String> temp = Stream.of(nums).map(Object::toString).collect(toList());
		return String.join(", ", temp);
	}
}
