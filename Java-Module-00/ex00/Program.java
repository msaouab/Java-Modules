
public class Program {
	public static void main(String[] args) {
		int sixDigitNumber = 123456;

		int sum = 0;
		sum += sixDigitNumber / 100000;
		sum += (sixDigitNumber / 10000) % 10;
		sum += (sixDigitNumber / 1000) % 10;
		sum += (sixDigitNumber / 100) % 10;
		sum += (sixDigitNumber / 10) % 10;
		sum += sixDigitNumber % 10;
		
		System.out.println("-> " + sum);
	}
}