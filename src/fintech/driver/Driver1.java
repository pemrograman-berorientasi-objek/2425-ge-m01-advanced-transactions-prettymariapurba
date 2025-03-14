package fintech.driver;

import fintech.model.Account;
import fintech.model.Transaction;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 12S23042 - Pretty Maria
 * @author 12S23049 - Clarissa Manurung
 */

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split("#");
            if (input[0].equals("create-account")) {
                String fullName = input[1];
                String username = input[2];
                accounts.put(username, new Account(fullName, username));
            } 
            
            else if (input[0].equals("create-transaction")) {
                String username = input[1];
                double amount = Double.parseDouble(input[2]);
                String timestamp = input[3];
                String description = input[4];
                
                if (accounts.containsKey(username)) {
                    Account account = accounts.get(username);
                    Transaction transaction = new Transaction(username, amount, timestamp, description);
                    if (!account.addTransaction(transaction)) {
                        System.out.println("Transaction denied for " + username + ". Insufficient funds.");
                    }
                }
            
            } else if (input[0].equals("show-account")) {
                String username = input[1];
                if (accounts.containsKey(username)) {
                    accounts.get(username).showAccount();
                }
            }
        }
        scanner.close();
    }
}