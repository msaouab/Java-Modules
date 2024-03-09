/**
 * Program
 */
public class Program {

	// display user details
	public static void displayUserDetails(User user) {
		System.out.println("User Identifier: " + user.getId());
		System.out.println("User Name: " + user.getName());
		System.out.println("User Balance: " + user.getBalance());
		System.out.println();
		// System.out.println("User Identifier: " + user.getId() + " Name: " + user.getName() + " Balance: " + user.getBalance());
		System.out.println();
	}

	// display transaction details
	public static void displayTransactionDetails(Transaction transaction) {
		System.out.println("Transaction Identifier: " + transaction.getIdentifier());
		System.out.println("Transaction Sender: " + transaction.getSender().getId() + " " + transaction.getSender().getName() + " " + transaction.getSender().getBalance());
		System.out.println("Transaction Receiver: " + transaction.getReceiver().getId() + " " + transaction.getReceiver().getName() + " " + transaction.getReceiver().getBalance());
		System.out.println("Transaction Category: " + transaction.getCategory());
		System.out.println("Transaction Amount: " + transaction.getAmount());
		System.out.println();
	}

	public static void main(String[] args) {
        try {
            // create user1 and user2
            User user1 = new User(1, "John", 1000);
            User user2 = new User(2, "Doe", 2000);

            User user3 = new User();
            user3.setId(3);
            user3.setName("Jane");
            user3.setBalance(3000);

            // display user1, user2, and user3 details before transaction
			displayUserDetails(user1);
			displayUserDetails(user2);
			displayUserDetails(user3);

            // create transactions
            Transaction transaction1 = new Transaction(user1, user3, "Food", 500);
            Transaction transaction2 = new Transaction(user2, user3, "Food", 500);

            // display transaction details
            System.out.println("===> Transaction 1 details:");
            displayTransactionDetails(transaction1);
            System.out.println("===> Transaction 2 details:");
            displayTransactionDetails(transaction2);

            // execute transactions
            transaction1.execute();
            transaction2.execute();

            // display user1, user2, and user3 details after transactions
			displayUserDetails(user1);
			displayUserDetails(user2);
			displayUserDetails(user3);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
	}
}