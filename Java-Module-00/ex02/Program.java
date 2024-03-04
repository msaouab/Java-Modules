import java.util.Scanner;

public class Program {

	static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int sumOfDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int coffeeRequest = 0;
			while (true) {
				System.out.print("-> ");

				int number = scanner.nextInt();
				if (number == 42) {
					System.out.println("Count of coffee-request – " + coffeeRequest);
					break;
				}

				int sum = sumOfDigits(number);
				if (isPrime(sum)) {
					coffeeRequest++;
				}
            }

		} catch (Exception e) {
			System.err.println("Invalid input");
		} finally {
			scanner.close();
		}
	}
}
