package fintech.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12S23042 Pretty Maria
 * @author 12S23049 Clarissa Manurung
 */
public class Account {
    private String username;
    private String fullName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public boolean addTransaction(Transaction transaction) {
        double newBalance = this.balance + transaction.getAmount();
        if (newBalance < 0) {
            return false;
        }
        this.balance = newBalance;
        transactions.add(transaction);
        return true;
    }

    public void showAccount() {
        System.out.println(username + "|" + fullName + "|" + balance);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}