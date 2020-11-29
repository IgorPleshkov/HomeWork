package Home_work.Stream;

public class Transaction {
    private String uid;
    private int sum;
    private Account account;

    public Transaction(String uid, int sum, Account account) {
        this.uid = uid;
        this.sum = sum;
        this.account = account;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
