package Home_work.Enums.HomeWork1;

import java.util.Objects;

public class User {
    private String fullName;
    private int salary;
    private Position position;

    public User(String fullName, Position position) {
        if (fullName.trim().length() < 4) throw new IllegalArgumentException("Полное имя д.б. больше 4-х символов!");
        if (salary < 0) throw new IllegalArgumentException("Зарплата не может быть отрицательной!");
        Objects.requireNonNull(position, "Должность is null!!!");
        this.fullName = fullName;
        this.salary = (int) (Math.random() * 50000) + 5000;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return fullName +
                ", зарплата: " + salary +
                ", должность: " + position;
    }
}
