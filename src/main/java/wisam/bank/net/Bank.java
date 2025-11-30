package wisam.bank.net;

public class Bank {

    private double balance;

    // Constructeur
    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    // 1) Déposer de l'argent
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 2) Retirer de l'argent
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    // 3) Lire le solde
    public double getBalance() {
        return balance;
    }
}
