package Home_work.Stream;

import java.time.LocalDate;

public class Pupil {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public Pupil(String name, String surname, LocalDate birthDate, Gender gender) {
        setName(name);
        setSurname(surname);
        setBirthDate(birthDate);
        this.gender = gender;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2) throw new IllegalArgumentException("Имя не может быть меньше 2-х символов!");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String soname) {
        if (soname.length() < 2) throw new IllegalArgumentException("Фамилия не может быть меньше 2-х символов!");
        this.surname = soname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Ученик : ")
                .append(name)
                .append(" ")
                .append(surname)
                .append(" Дата рождения: ")
                .append(birthDate)
                .append(" Пол: ")
                .append(gender);
        return sb.toString();
    }

    enum  Gender {
        MALE, FEMALE
    }


}
