package Home_work.Multithreading.Pizzeria;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    private List<Client> clients = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void setEmployees(Employee employee) {
        employees.add(employee);
    }

    public void beginWork() {
        LinkedBlockingQueue<Order> orders1 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Order> orders2 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Order> orders3 = new LinkedBlockingQueue<>();
        List<Thread> threads = new ArrayList<>();
        for (Client client : clients) {
        threads.add( new Thread(() -> {
                    try {
                        orders1.put(client.getOrder());
                        System.out.println("Клиент: " + client.toString() + " | Состав заказа: " + client.getOrder().toString() + " :: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    try {
                        orders3.take();
                        System.out.println("Клиент: " + client.toString() + " получил заказ | Состав заказа: " + client.getOrder().toString() + " :: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
            }));
        }

        for (Employee employee : employees) {
            if (employee.getHumanType() == HumanType.WAITER) {
                threads.add(new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            orders2.put(orders1.take());
                            System.out.println("Официант " + employee.getName() + " принял заказ  :: " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }));
            } else if (employee.getHumanType() == HumanType.COOK){
                threads.add(new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(4000);
                            orders3.put(orders2.take());
                            System.out.println("Повар " + employee.getName() + " приготовил заказ " + " :: " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                   }
                }));
            }
        }
        for (Thread t : threads){
            t.start();
        }

    }
}
