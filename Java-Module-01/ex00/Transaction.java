import java.util.UUID;

/**
 * Transaction
 */
public class Transaction {
	private UUID Identifier;
	private User Receiver;
	private User Sender;
	private String Category;
	private Integer Amount;

	Transaction(User sender, User receiver, String category, Integer amount) {
		Identifier = UUID.randomUUID();
		Sender = sender;
		Receiver = receiver;
		Category = category;
		Amount = amount;
	}

	public void setReceiver(User receiver) {
		Receiver = receiver;
	}

	public void setSender(User sender) {
		Sender = sender;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

	public void setIdentifier(UUID identifier) {
		Identifier = identifier;
	}

	public UUID getIdentifier() {
		return Identifier;
	}

	public User getReceiver() {
		return Receiver;
	}

	public User getSender() {
		return Sender;
	}

	public String getCategory() {
		return Category;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void displayTransaction() {
		System.out.println("Transaction ID: " + Identifier);
		System.out.println("Sender: " + Sender.getName());
		System.out.println("Receiver: " + Receiver.getName());
		System.out.println("Category: " + Category);
		System.out.println("Amount: " + Amount);
	}
}