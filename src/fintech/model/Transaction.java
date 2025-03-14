package fintech.model;

/**
 * @author 12S23042 Pretty Maria 
 * @author 12S23049 Clarissa Manurung
 */

 
public class Transaction {
    private static int counter = 0;
    private int id;
    private String accountUsername;
    private double amount;
    private String timestamp;
    private String description;

    public Transaction(String accountUsername, double amount, String timestamp, String description) {
        this.id = ++counter;
        this.accountUsername = accountUsername;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return id + "|" + accountUsername + "|" + amount + "|" + timestamp + "|" + description;
    }
}