import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Program Java
 */
public class Program {

	/**
	 * printError
	 * 
	 * @param message String
	 * @return void
	 */
	static void printError(String message) {
		System.err.println(message);
		System.exit(-1);
	}

	/**
	 * ft_length
	 * 
	 * @param array
	 * @return int
	 */
	static int ft_length(String[] array) {
		int length = 0;
		for (String s : array) {
			length++;
		}
		return length;
	}

	/**
	 * printWeekGrades
	 * 
	 * @param weekGrades
	 * @param currentWeek
	 * @return void
	 */
	static void printWeekGrades(Map<Integer, Integer> weekGrades, int currentWeek) {
		for (int i = 1; i <= currentWeek; i++) {
			System.out.print("\tWeek " + i + " ");
			if (weekGrades.containsKey(i)) {
				int minScore = weekGrades.get(i);
				for (int j = 0; j < minScore; j++) {
					System.out.print("=");
				}
				System.out.println(">");
			}
		}
	}

	/**
	 * Main entry point
	 * 
	 * @param args
	 * @return void
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Integer> weekGrades = new HashMap<>();
		final int MAX_WEEKS = 18;

		try {
			int currentWeek = 0;
			int week = 1;
			System.out.print("-> ");

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (line.equals("42")) {
					break;
				}

				System.out.print("-> ");
				String[] gradesScore = null;

				if (line.startsWith("Week")) {
					week = Integer.parseInt(line.split("\\s+")[1]);
					if (week != currentWeek + 1)
						printError("IllegalArgument");
					currentWeek = week;
				} else {
					gradesScore = line.split("\\s+");

					int length = ft_length(gradesScore);
					if (length != 5)
						printError("IllegalArgument: Exactly 5 tests are required for each week.");
					int minGrade = Integer.MAX_VALUE;
					for (String g : gradesScore) {
						int grade = Integer.parseInt(g);
						if (grade < 1 || grade > 9)
						printError("IllegalArgument: Each test must be graded between 1 and 9.");
						minGrade = Math.min(minGrade, grade);
					}
					weekGrades.put(currentWeek, minGrade);
				}
				if (weekGrades.size() == MAX_WEEKS)
					break;
			}

			printWeekGrades(weekGrades, currentWeek);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}