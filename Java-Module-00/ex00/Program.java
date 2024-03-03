
public class Program {
	public static void main(String[] args) {
		int sixDigitNumber = 123456;

		// check if the number is int
		if (sixDigitNumber != (int)sixDigitNumber) {
			System.out.println("The variable: `sixDigitNumber` is not a int number");
			return;
		}
		// convert the number to a string
		String numbeString = String.valueOf(sixDigitNumber);

		// check if the number is a six digit number
		if (numbeString.length() != 6) {
			System.out.println("The number: `" + numbeString + "` is not a six digit number");
			return;
		}
		// calculate the sum of the digits
		int sum = 0;
		while (sixDigitNumber > 0) {
			sum += sixDigitNumber % 10;
			sixDigitNumber /= 10;
		}

		System.out.println("The sum of the digits is: " + sum);
	}
}