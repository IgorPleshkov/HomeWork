package Courseworks.Fitness;

import java.time.LocalDate;

public class Client {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Client(String name, String surname, String birthDate) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Имя должно быть не меньше 2-х символов");
        if (surname == null || surname.trim().length() < 2) throw new IllegalArgumentException("Фамилия должна быть не меньше 2-х символов");
        if (!IsValidDate.isValidDate(birthDate)) throw new IllegalArgumentException("Неправильный формат даты рождения!");
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
