package Home_work.ListsHomeWork.Car;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);


        Comparator<Car> carComparator = new PriceComparator().
                thenComparing(new ColorComparator()).
                thenComparing(new BrandComparator());

        TreeSet<Car> cars = new TreeSet<>(carComparator);

        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);

        for(Car c : cars){
            System.out.println(c.toString());
        }

    }
}