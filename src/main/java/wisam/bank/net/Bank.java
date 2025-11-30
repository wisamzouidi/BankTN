package wisam.bank.net;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Ajouter un compte
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Afficher tous les comptes
    public void showAccounts() {
        System.out.println("=== " + name + " ===");
        for (Account acc : accounts) {
            acc.showInfo();
        }
    }

    // Trouver un compte par numéro
    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}
