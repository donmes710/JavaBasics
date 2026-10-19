class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
        } else {
            System.out.println(
                "Balance cannot be negative!"
            );
        }
    }
}

public class encapsulation{
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(500);
        acc.setBalance(-100);
        System.out.println(acc.getBalance());
    }
}