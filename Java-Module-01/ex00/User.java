/**
 * User
 */
public class User {
    private Integer Id;
    private String Name;
    private Integer Balance;

    User(Integer id, String name, Integer balance) {
		if (balance < 0 || name.length() == 0) {
            throw new IllegalArgumentException("Invalid balance or name for user: " + id + " " + name);
        }
		Id = id;
		Name = name;
		Balance = balance;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        if (name.length() == 3) {
            System.err.println("Name cannot be empty");
        } else {
            Name = name;
        }
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            System.err.println("Balance cannot be negative");
        } else {
            Balance = balance;
        }
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getBalance() {
        return Balance;
    }
}