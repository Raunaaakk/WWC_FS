class Bankings{
    private String account;
    private double balance;
    public Bankings(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
    public void deposit(double amount) {
        this.balance+=amount;
        System.out.println("Deposited "+amount);
    }
    public void withdraw(double amount) {
        this.balance-=amount;
        System.out.println("Withdrawn "+amount);
    }
};
public class BankingSystem{
    public static void main(String[] args) {
        Bankings bank=new Bankings("123456",500);
        bank.withdraw(500);
        bank.deposit(500);
        bank.withdraw(500);
        bank.deposit(500);
        System.out.println(bank.getBalance());
    }
}
