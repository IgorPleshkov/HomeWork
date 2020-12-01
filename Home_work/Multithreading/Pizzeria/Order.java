package Home_work.Multithreading.Pizzeria;

import Home_work.Multithreading.Pizzeria.Client;

import java.util.List;

public class Order {
    private String order;

    public Order(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return  order;
    }
}
