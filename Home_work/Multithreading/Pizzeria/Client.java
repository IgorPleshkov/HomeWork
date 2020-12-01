package Home_work.Multithreading.Pizzeria;

public class Client extends Human {
    private Order order;

    public Client(HumanType humanType, String name, Order order) {
        super(humanType, name);
        if (order.getOrder().trim().length() < 1) throw new IllegalArgumentException("Пустой заказ!");
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}

