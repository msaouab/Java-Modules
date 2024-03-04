import java.util.Scanner;

/**
 * Program Java
 */
public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int maxWeeks = 18 * 2;
			while (maxWeeks-- > 0) {
				System.out.print("-> ");

				int number = scanner.nextInt();
				if (number == 42) {
					break;
				}
            }
			System.out.println("End of the program: " + maxWeeks);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}