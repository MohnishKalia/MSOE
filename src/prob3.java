import java.util.Scanner;
public class prob3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double widthInFeet = Double.parseDouble(in.next());
		double heightInFeet = Double.parseDouble(in.next());
		double width = widthInFeet * 12;
		double remainder = width % 4.0;
		int widthInches = 0;
		if (remainder > 0) {
			widthInches = (int) (width + (4-remainder));
		} else {
			widthInches = (int) width;
		}
		double height = heightInFeet * 12;
		double remainder1 = height % 2.25;
		double heightInches = height - remainder1;
		int numRows = (int) (heightInches/2.25);
		int num8 = 0;
		int num4 = 0;
		if (widthInches % 8 == 0) {
			double avg8sPerRow = (widthInches/8.0 + (widthInches/8.0 -1)) / 2;
			//if even num of rows
			if ((numRows & 1) == 0) {
				num8 = (int) (numRows * avg8sPerRow);
				num4 = numRows;
			} else {
				num8 = (int) ((numRows - 1) * avg8sPerRow);
				num8 += widthInches/8;
				num4 = numRows - 1;
			}
		} else {
			int num8sPerRow = (widthInches-4)/8;
			num8 = numRows * num8sPerRow;
			num4 = numRows;
		}
		System.out.println("Full bricks: " + num8);
		System.out.println("Half bricks: " + num4);
	}
}