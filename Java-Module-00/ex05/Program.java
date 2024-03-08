import java.util.Scanner;

public class Program {

	public final static int LENGTH_NAME = 10;
	public final static int MAX_STUDENTS = 10;
	public final static int START_LESSONS = 1;
	public final static int FINISH_LESSONS = 6;

	private static Scanner scanner = new Scanner(System.in);
	private static String[] students = new String[MAX_STUDENTS + 1];
	private static String[][] classes = new String[8][10];
	private static String[][][][] attendance = new String[10][31][10][1];
	private static String[] days = { "", "MO", "TU", "WE", "TH", "FR", "SA", "SU" };

	
	/**
	 * printSpace
	 * 
	 * @param len
	 * @param str
	 * @return void
	 */
	public static void printSpace(int len, String str) {
		for (int i = 0; i < len; i++) {
			System.out.print(" ");
		}
		System.out.print(str);
	}
	
	/**
	 * printError
	 * 
	 * @param message
	 * @return void
	 */
	public static void printError(String message) {
		System.err.println("IllegalArgument: " + message);
		scanner.close();
		System.exit(-1);
	}

	/**
	 * readStudentsName
	 * 
	 * @return void
	 */
	public static void readStudentsName() {
		for (int i = 0; i <= MAX_STUDENTS; i++) {
			System.out.print("-> ");
			students[i] = scanner.nextLine();
			if (students[i].length() > LENGTH_NAME || students[i].contains(" ")) {
				printError("Student name must be less than 10 characters and no spaces.");
			}
			if (students[i].equals(".")) {
				students[i] = null;
				return;
			}
			if (i == 10) {
				printError("The maximum number of students must be 10.");
			}
		}
	}

	/**
	 * fillClasses
	 * 
	 * @param classes
	 * @param time
	 * @return void
	 */
	public static void fillClasses(String[] classes, String time) {
		int i = 0;
		for (; i < classes.length && classes[i] != null; i++) {
		}
		if (i < 10) {
			int isTime = Integer.parseInt(time);
			if (isTime < START_LESSONS || isTime > FINISH_LESSONS) {
				printError("Time must be between 1 and 6.");
			}
			classes[i] = time;
		}
	}

	/**
	 * readTimeClasses
	 * 
	 * @return void
	 */
	public static void readTimeClasses() {
		System.out.print("-> ");
		String time = scanner.next();
		String day;

		while (!time.equals(".")) {
			System.out.print("-> ");
			day = scanner.next();
			int dayIndex = isValidDay(day);
			if (dayIndex != -1) {
				fillClasses(classes[dayIndex], time);
			}
			time = scanner.next();
		}
	}

	/**
	 * isValidDay
	 * 
	 * @param day
	 * @return int
	 */
	public static int isValidDay(String day) {
		for (int i = 1; i < days.length; i++) {
			if (day.equals(days[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * getLessonInWeek
	 * 
	 * @param date
	 * @param hour
	 * @return int
	 */
	public static int getLessonInWeek(int date, String hour) {
		int week = date % 7 + 1;
		int i = 0;

		for (; i < 10; i++) {
			if (classes[week][i] != null && classes[week][i].equals(hour)) {
				break;
			}
		}

		if (i < 10) {
			return i;
		}
		return 0;
	}

	/**
	 * isValidAttendance
	 * 
	 * @return void
	 */
	public static void isValidAttendance() {
		int isValide = 0;
		for (int i = 0; i < students.length && students[i] != null; i++) {
			for (int j = 1; j < 31; j++) {
				int dayIndex = j % 7 + 1;
				for (int k = 0; k < 10 && classes[dayIndex][k] != null; k++) {
					if (attendance[i][j][k][0] != null && attendance[i][j][k][0].equals("HERE")) {
						isValide++;
					}
				}
			}
		}
		if (isValide == 0) {
			printError("You're entering the attendance of the students.");
		}
	}

	/**
	 * readAttendanceRecording
	 * 
	 * @return void
	 */
	public static void readAttendanceRecording() {
		System.out.print("-> ");
		String student = scanner.next();
		String hour;

		while (!student.equals(".")) {
			System.out.print("-> ");
			int studentIndex, date, lesson;
			hour = scanner.next();
			date = scanner.nextInt();
			String status = scanner.next();

			for (studentIndex = 0; studentIndex < students.length; studentIndex++) {
				if (students[studentIndex].equals(student))
					break;
			}
			lesson = getLessonInWeek(date, hour);
			attendance[studentIndex][date][lesson][0] = status;
			student = scanner.next();
		}
		isValidAttendance();
	}

	/**
	 * printTimeClasses
	 * 
	 * @return void
	 */
	private static void printTimeClasses() {
		printSpace(11, "|");

		for (int i = 1; i < 31; i++) {
			int dayIndex = i % 7 + 1;

			for (int classIndex = 0; classIndex < 10 && classes[dayIndex][classIndex] != null; classIndex++) {
				System.out.print(classes[dayIndex][classIndex] + ":00 ");
				System.out.print(days[dayIndex] + " " + i + "|");
			}
			
			if (i == 30) {
				System.out.println();
			}
		}
	}

	/**
	 * printTimeTable
	 * 
	 * @return void
	 */
	public static void printTimeTable() {
		for (int i = 0; i < students.length && students[i] != null; i++) {
			System.out.print(students[i]);
			int len = 11 - students[i].length();
			printSpace(len, "|");
			for (int j = 1; j < 31; j++) {
				int dayIndex = j % 7 + 1;
				for (int k = 0; k < 10 && classes[dayIndex][k] != null; k++) {
					if (j > 9) {
						System.out.print(" ");
					}
					if (attendance[i][j][k][0] != null && attendance[i][j][k][0].equals("HERE")) {
						printSpace(8, "1|");
					} else if (attendance[i][j][k][0] != null && attendance[i][j][k][0].equals("NOT_HERE")) {
						printSpace(7, "-1|");
					} else {
						printSpace(9, "|");
					}
				}
			}
			System.out.println();
		}
	}

	/**
	 * main
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		readStudentsName();
		readTimeClasses();
		readAttendanceRecording();
		printTimeClasses();
		printTimeTable();
		scanner.close();
	}
}