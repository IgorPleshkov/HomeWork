package Home_work.Multithreading.task;

public class Application {
    public static void main(String[] args) {
        Account account1 = new Account(123456, 50000);
        Account account2 = new Account(654321, 0);
        Bank bank = new Bank();
        bank.transferMoney(account1, account2, 30000);
    }
}
