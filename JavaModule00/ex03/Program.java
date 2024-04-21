import java.util.Scanner;

/**
 * Program Java
 */
public class Program {
	private static final int MAX_WEEKS = 18;
	private static long colectMinGrade = 0;
	private static int currentWeek = 0;

	/**
	 * printError
	 * 
	 * @return void
	 */
	static void printError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}

	/**
	 * printWeekGrades
	 * 
	 * @param minGrade
	 * @param currentWeek
	 * @return void
	 */
	static void printWeekGrades() {
		for (int i = 0; i < currentWeek; i++) {
			int week = i + 1;
			System.out.print("Week " + week);
			int minGrade = (int) (colectMinGrade % 10);
			colectMinGrade /= 10;
			for (int j = 0; j < minGrade; j++) {
				System.out.print("=");
			}
			System.out.println(">");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";

		while (true) {
			System.out.print("-> ");
			line = scanner.next();
			if (line.equals("42")) {
				break;
			} else if (line.equals("Week")) {
				System.out.print("-> ");
				long week = scanner.nextInt();
				if (week != currentWeek + 1)
					printError();
				currentWeek++;
				int minGrade = scanner.nextInt();
				for (int i = 0; i < 4; i++) {
					int grade = scanner.nextInt();
					if (grade < 0 || grade > 9)
						printError();
					if (grade < minGrade)
						minGrade = grade;
				}
				colectMinGrade *= 10;
				colectMinGrade += minGrade;
			}
			if (currentWeek == MAX_WEEKS)
				break;
		}
		long reverseColectMinGrade = 0;
		while (colectMinGrade != 0) {
			int minGrade = (int) (colectMinGrade % 10);
			reverseColectMinGrade *= 10;
			reverseColectMinGrade += minGrade;
			colectMinGrade /= 10;
		}
		colectMinGrade = reverseColectMinGrade;
		printWeekGrades();

		scanner.close();
	}
}
