package wisam.bank.net;

public class Account {

    private String accountNumber;
    private String owner;
    private double balance;

    public Account(String accountNumber, String owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void showInfo() {
        System.out.println("Compte: " + accountNumber + ", Propriétaire: " + owner + ", Solde: " + balance);
    }
}
