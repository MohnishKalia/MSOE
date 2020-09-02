package prob3;
import java.util.Scanner;
public class Prob3 {

	public static void main(String[] args) {
		try(Scanner input = new Scanner(System.in)){
			System.out.println("Length:");
			double length = input.nextDouble();
			System.out.println("Height:");
			double height = input.nextDouble();
			
		}
	}
	
	public static int convertLength(double length) {
		double inches = (length * 12);
		int lengthOfIt = 0;
		double remainder = inches % 4.0;
		double toAdd = 4-remainder;
		lengthOfIt = (int)(inches+toAdd);
		return lengthOfIt;
	}
	
	public static int convertWidth(double width) {
		double inches = (width * 12);
		int lengthOfIt = 0;
		double remainder = inches % 4.0;
		lengthOfIt = (int)(inches-remainder);
		return lengthOfIt;
	}

}
