package Home_work.Lambda;

import Home_work.Lambda.University;
import com.itmo.jjd.Lesson22.Lambda.Course;

import java.util.function.Predicate;

public class HomeWork3 {
    public static void main(String[] args) {
        /*
        Использовать реализованный в п.3 метод для получения списков курсов:
        продолжительностью менее 3х месяцев;
        стоимостью менее 20000;
        курсов с названием JJD;
        продолжительностью менее 3х месяцев и стоимостью менее 20000;
        продолжительностью менее 3х месяцев и стоимостью менее 20000 или курсов с названием JJD;
         */

        Predicate<Course> filter1 = cource -> cource.getDuration() >= 3;
        print(addUniversity(), filter1);

        Predicate<Course> filter2 = cource -> cource.getPrice() >= 20000;
        print(addUniversity(), filter2);

        Predicate<Course> filter3 = cource -> !(cource.getName().equals("JJD"));
        print(addUniversity(), filter3);

        print(addUniversity(), filter1.and(filter2));

        print(addUniversity(), filter1.and(filter2).or(filter3));
    }

    public static University addUniversity() {
        University university = new University();
        for (int i = 0; i < 20; i++) {
            university.addCourse(Course.getInstance());
        }
        return university;
    }

    public static void print(University university, Predicate filter) {
        System.out.println(university.filtered(filter).toString() + "\n");
    }
}
