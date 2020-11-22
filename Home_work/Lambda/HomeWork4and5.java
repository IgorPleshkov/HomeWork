package Home_work.Lambda;

import Home_work.Lambda.University;
import com.itmo.jjd.Lesson22.Lambda.Course;

import java.util.function.Function;
import java.util.function.Predicate;

public class HomeWork4and5 {
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
        printWithFilter(addUniversity(), filter1);

        Predicate<Course> filter2 = cource -> cource.getPrice() >= 20000;
        printWithFilter(addUniversity(), filter2);

        Predicate<Course> filter3 = cource -> !(cource.getName().equals("JJD"));
        printWithFilter(addUniversity(), filter3);

        printWithFilter(addUniversity(), filter1.and(filter2));

        printWithFilter(addUniversity(), filter1.and(filter2).or(filter3));

         /*
        Используя метод foreach увеличить стоимость всех курсов на 10000.
         */

        University university = addUniversity();
        university.getCourses().forEach(course -> course.setPrice(course.getPrice()+10000));
        System.out.println(university.toString());

    }

    public static University addUniversity() {
        University university = new University();
        for (int i = 0; i < 20; i++) {
            university.addCourse(Course.getInstance());
        }
        return university;
    }

    public static void printWithFilter(University university, Predicate filter) {
        System.out.println(university.filtered(filter).toString() + "\n");
    }
}
