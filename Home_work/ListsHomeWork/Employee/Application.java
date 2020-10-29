package Home_work.ListsHomeWork.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {

        Comparator<Employee> employeeComparator1 = new nameComparator();
        Comparator<Employee> employeeComparator2 = employeeComparator1.thenComparing(new salaryComparator());
        Comparator<Employee> employeeComparator3 = employeeComparator2.thenComparing(new ageComparator()).thenComparing(new companyComparator());

        List<Employee> employeeList = Employee.employeeGenerator(30);

        TreeSet<Employee> employees1 = new TreeSet<>(employeeComparator1);
        employees1.addAll(employeeList);
        System.out.println("Список 1:");
        for (Employee e : employees1){ System.out.println(e); }

        TreeSet<Employee> employees2 = new TreeSet<>(employeeComparator2);
        employees2.addAll(employeeList);
        System.out.println("Список 2:");
        for (Employee e : employees2){ System.out.println(e); }

        TreeSet<Employee> employees3 = new TreeSet<>(employeeComparator3);
        employees3.addAll(employeeList);
        System.out.println("Список 3:");
        for (Employee e : employees3){ System.out.println(e); }



    }
}
