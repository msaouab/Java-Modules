/**
 * User
 */
public class User {
	private int Id;
	private String Name;
	private int Balance;

	User(int id, String name, int balance) {
		Id = id;
		Name = name;
		Balance = balance;
		System.out.println("User: " + Name + " was created with ID: " + Id + " and balance: " + Balance);
	}

}