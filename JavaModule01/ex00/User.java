package JavaModule01.ex00;

/**
 * User
 */
public class User {
    private Integer Id;
    private String Name;
    private Integer Balance;

    User() {
        this.Id = 0;
        this.Name = "";
        this.Balance = 0;
    }

    User(Integer id, String name, Integer balance) {
        setId(id);
        setName(name);
        setBalance(balance);
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name cannot be empty or less than 3 characters: " + name);
        }
        this.Name = name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative: " + balance);
        }
        this.Balance = balance;
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