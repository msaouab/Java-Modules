package JavaModule01.ex00;


/**
 * Program
 */
public class Program {

	/**
	 * displayUserInfo
	 * 
	 * @param args
	 * @return void
	 */
	public static void displayUserInfo(User user) {
		System.out.println("User ID: " + user.getId() + ", Name: " + user.getName() + ", Balance: " + user.getBalance());
		System.out.println();
	}

	/**
	 * displayTransactionInfo
	 * 
	 * @param args
	 * @return void
	 */
	public static void displayTransactionInfo(Transaction transaction) {
		System.out.println(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", -"
				+ transaction.getAmount() + ", OUTCOME, " + transaction.getId());
		System.out.println(transaction.getRecipient().getName() + " -> " + transaction.getSender().getName() + ", +"
				+ transaction.getAmount() + ", INCOME, " + transaction.getId());
		System.out.println();
	}

	/**
	 * main
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		User Mike = new User(1, "Mike", 100);
		User John = new User(2, "John", 200);

		// display user info
		displayUserInfo(Mike);
		displayUserInfo(John);

		// transfer amount
		Transaction transaction = new Transaction(Mike, John, 50, "Food");
		Transaction transaction2 = new Transaction(John, Mike, 100, "Salary");

		// display transaction info
		displayTransactionInfo(transaction);
		displayTransactionInfo(transaction2);

		// display user info
		displayUserInfo(Mike);
		displayUserInfo(John);
	}
}
