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
        setSender(sender);
        setReceiver(receiver);
        setCategory(category);
        setAmount(amount);
        this.Identifier = UUID.randomUUID();
    }

    public void setSender(User sender) {
        if (sender == null) {
            throw new IllegalArgumentException("Sender cannot be null");
        }
        this.Sender = sender;
    }

    public void setReceiver(User receiver) {
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver cannot be null");
        }
        this.Receiver = receiver;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.Category = category;
    }

    public void setAmount(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive: " + amount);
        }
        this.Amount = amount;
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public User getSender() {
        return Sender;
    }

    public User getReceiver() {
        return Receiver;
    }

    public String getCategory() {
        return Category;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void execute() {
        if (Sender.getBalance() < Amount) {
            throw new IllegalArgumentException("Sender does not have enough balance for this transaction");
        }
        Sender.setBalance(Sender.getBalance() - Amount);
        Receiver.setBalance(Receiver.getBalance() + Amount);
	}
}