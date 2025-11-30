package wisam.bank.net;

import wisam.bank.net.model.Bank;
import wisam.bank.net.model.Account;

public class App {
    public static void main(String[] args) {
        Bank myBank = new Bank("Banque TN");

        Account acc1 = new Account("TN001", "Ali", 1000);
        Account acc2 = new Account("TN002", "Sara", 2000);

        myBank.addAccount(acc1);
        myBank.addAccount(acc2);

        acc1.deposit(500);
        acc2.withdraw(300);

        myBank.showAccounts();
    }
}
