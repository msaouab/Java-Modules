import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("-> ");
		try {
			int number = scanner.nextInt();
			if (number <= 1) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			int iterations = 0;

			for (int i = 2; i <= Math.sqrt(number); i++) {
				iterations++;
				if (number % i == 0) {
					System.out.println("false " + iterations);
					return ;
				}
			}
			iterations++;
			System.out.println("true " + iterations);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}

		scanner.close();
	}
}