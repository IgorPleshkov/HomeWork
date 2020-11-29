package Home_work.Stream;

public class Account {
    private String id;
    private int ballance;

    public Account(String id, int ballance) {
        this.id = id;
        this.ballance = ballance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBallance() {
        return ballance;
    }

    public void setBallance(int ballance) {
        this.ballance = ballance;
    }
}
