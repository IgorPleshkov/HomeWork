package Home_work.ListsHomeWork.Employee;
// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    private final static int MIN_AGE = 21;
    private final static int MAX_AGE = 60;
    private final static int MIN_SALARY = 50000;
    private final static int MAX_SALARY = 150000;

    // TODO: конструктор, геттеры и сеттеры

    private Employee(String name, String company, int salary, int age) {
        setSalary(salary);
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    public void setSalary(int salary) {
        if (salary < MIN_SALARY) throw  new IllegalArgumentException("ЗП д.б. не меньше " + MIN_SALARY);
        this.salary = salary;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
            int randomName = (int) (Math.random() * (names.length-1));
            int randomCompany = (int) (Math.random() * (companies.length-1));
            int randomSalary = (int) (Math.random() * (MAX_SALARY - MIN_SALARY)) + MIN_SALARY;
            int randomAge = (int) (Math.random() * (MAX_AGE - MIN_AGE)) + MIN_AGE;
            employees.add(new Employee(names[randomName], companies[randomCompany], randomSalary, randomAge));
        }
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }


}


class nameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class salaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class ageComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class companyComparator implements Comparator<Employee>{
@Override
public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
        }
}

