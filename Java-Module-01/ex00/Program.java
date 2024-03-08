/**
 * Program
 */
public class Program {

	public static void main(String[] args) {
		try {
			User user1 = new User(1, "med", -1000);
			User user2 = new User(2, "saouab", 2000);
			
			// display user1 and user2
			System.out.println("User1: " + user1.getId() + " " + user1.getName() + " " + user1.getBalance());
			System.out.println("User2: " + user2.getId() + " " + user2.getName() + " " + user2.getBalance());
			
			// create a transaction
			Transaction transaction = new Transaction(user1, user2, "Food", 0);
			transaction.displayTransaction();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			// TODO: handle exception
		}

		// display transaction
	}
}