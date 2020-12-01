package Home_work.Multithreading.Pizzeria;


public class Application {
    public static void main(String[] args) {

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.addClient(new Client(HumanType.CLIENT, "Вася", new Order("Пицца")));
        pizzeria.addClient(new Client(HumanType.CLIENT, "Петя", new Order("Суши")));
        pizzeria.addClient(new Client(HumanType.CLIENT, "Маша", new Order("Кофе")));
        pizzeria.addClient(new Client(HumanType.CLIENT, "Коля", new Order("Смузи")));

        pizzeria.addEmployee(new Employee(HumanType.WAITER, "Аркадий"));
        pizzeria.addEmployee(new Employee(HumanType.WAITER, "Роман"));
        pizzeria.addEmployee(new Employee(HumanType.COOK, "Павел"));

        pizzeria.beginWork();

    }

}
