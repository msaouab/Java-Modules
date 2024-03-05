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
		String studentName;

		int countPoints = 0;
		try {
			while (true) {
				System.out.print("-> ");
				studentName = scanner.nextLine();
				if (studentName.equals(".")) {
					countPoints++;
				}
				students[studentCount] = studentName;
				studentCount++;
				System.out.println("student: " + studentName);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			scanner.close();
			System.out.println("Finally");
		}
	}
}
