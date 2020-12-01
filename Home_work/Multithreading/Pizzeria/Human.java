package Home_work.Multithreading.Pizzeria;

abstract public class Human {
    private HumanType humanType;
    private String name;

    public Human(HumanType humanType, String name) {
        if (name.trim().length() < 2) throw new IllegalArgumentException("Имя не д.б меньше 2-х символов!");
        this.humanType = humanType;
        this.name = name;
    }

    public HumanType getHumanType() {
        return humanType;
    }

    public String getName() {
        return name;
    }
}
