package JavaModule01.ex00;
import java.util.UUID;

/**
 * Transaction
 */
public class Transaction {
    private UUID Id;
    private User Sender;
    private User Recipient;
    private Integer Amount;
    private String Category;

    Transaction(User sender, User recipient, Integer amount, String category) {
        setId(UUID.randomUUID());
        setSender(sender);
        setRecipient(recipient);
        setAmount(amount);
        setCategory(category);
        transferAmount();
    }

    public void setId(UUID id) {
        this.Id = id;
    }

    public void setSender(User sender) {
        this.Sender = sender;
    }

    public void setRecipient(User recipient) {
        this.Recipient = recipient;
    }

    public void setAmount(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative: " + amount);
        }
        this.Amount = amount;
    }

    public void setCategory(String category) {
        if (category.length() < 3) {
            throw new IllegalArgumentException("Category cannot be empty or less than 3 characters: " + category);
        }
        this.Category = category;
    }

    public UUID getId() {
        return Id;
    }

    public User getSender() {
        return Sender;
    }

    public User getRecipient() {
        return Recipient;
    }

    public Integer getAmount() {
        return Amount;
    }

    public String getCategory() {
        return Category;
    }

    public void transferAmount() {
        if (this.Sender.getBalance() < this.Amount) {
            throw new IllegalArgumentException("Insufficient balance: " + this.Sender.getBalance());
        }
        this.Sender.setBalance(this.Sender.getBalance() - this.Amount);
        this.Recipient.setBalance(this.Recipient.getBalance() + this.Amount);
    }
}