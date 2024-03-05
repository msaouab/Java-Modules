import java.util.Scanner;

/**
 * Program
 */

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create a list of students
		String[] students = new String[10];
		int studentCount = 0;
		System.out.println("-> ");
		String studentName;

		while (true) {
			studentName = scanner.nextLine();
			if (studentName.equals("exit")) {
				break;
			}
			students[studentCount] = studentName;
			studentCount++;
			System.out.println("student: " + studentName);
		}

		scanner.close();
	}
}
