import java.util.Scanner;

public class Program {
	private static int[] frequency = new int[65535];
	private static char[] chars = new char[65535];
	private static int len = 0;

	/**
	 * Sorts the frequency array and the chars array
	 * 
	 * @param frequency
	 * @param chars
	 * @param len
	 */
	public static void sortFrequency() {
		int i = 1;
		while (i < len) {
			int j = i;
			while (j > 0 && (frequency[j - 1] < frequency[j]
					|| (frequency[j - 1] == frequency[j]) && (chars[j - 1] > chars[j]))) {
				int tmp = frequency[j];
				frequency[j] = frequency[j - 1];
				frequency[j - 1] = tmp;
				char temp = chars[j];
				chars[j] = chars[j - 1];
				chars[j - 1] = temp;
				j = j - 1;
			}
			i++;
		}
	}

	/**
	 * Displays the histogram
	 * 
	 * @param frequency
	 * @param chart
	 * @param chars
	 * @param len
	 */
	public static void displayHistogram(int[] chart) {
		for (int k = 10; k >= 0; k--) {
			for (int m = 0; m < 10 && m < len; m++) {
				if (chart[m] == k && frequency[m] >= 10)
					System.out.print("|" + frequency[m] + "");
				if (chart[m] == k && frequency[m] < 10)
					System.out.print("|" + frequency[m] + " ");
				if (chart[m] > k)
					System.out.print("|# ");
			}
			System.out.println();
		}
		for (int k = 0; k < 10 && k < len; k++) {
			System.out.print("|" + chars[k] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("-> ");
		String input = scanner.nextLine();
		scanner.close();
		if (input.length() == 0) {
			System.out.println("No input");
			return;
		}

		char[] charsArr = input.toCharArray();

		char c = charsArr[0];
		boolean isFirst = true;
		for (int i = 0; i < charsArr.length; i++) {
			c = charsArr[i];
			isFirst = true;
			for (int j = 0; j < len; j++) {
				if (chars[j] == c) {
					frequency[j]++;
					isFirst = false;
					break;
				}
			}
			if (isFirst) {
				chars[len] = c;
				frequency[len] = 1;
				len++;
			}
		}

		sortFrequency();

		int chart[] = new int[10];
		for (int k = 0; k < 10 && k < len; k++) {
			chart[k] = frequency[k] * 10 / frequency[0];
		}
		displayHistogram(chart);
	}
}
