class BankAccount {
    String accountHolder;
    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate = 4.5;

    SavingsAccount(String accountHolder) {
        super(accountHolder);
    }
    @Override
    void displayDetails() {
        System.out.println("Interest rate: " + interestRate + " %");
    }
}
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Rabin");
        account.displayDetails();
        System.out.println("-------------------");
        SavingsAccount savings = new SavingsAccount("Rabin");
        savings.displayDetails();
    }
}