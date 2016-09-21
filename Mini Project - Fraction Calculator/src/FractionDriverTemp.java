import java.util.Scanner;

public class FractionDriverTemp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int index = s.indexOf('/');
		int numerator = Integer.parseInt(s.substring(0, index));
		int denominator = Integer.parseInt(s.substring(index + 1));
		System.out.println("Numerator = " + numerator);
		System.out.println("Denominator = " + denominator);
		scan.close();
	}
}
