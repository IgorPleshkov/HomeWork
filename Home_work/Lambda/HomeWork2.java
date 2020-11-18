package Home_work.Lambda;

import com.itmo.jjd.Lesson15.Collection.Student;
import com.itmo.jjd.Lesson22.Lambda.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class HomeWork2 {
    public static void main(String[] args) {
        StudentList students = new StudentList();
        students.addStudent(new Student("Иван", "Иванов", 33));
        students.addStudent(new Student("Алексей", "Алексеев", 25));
        students.addStudent(new Student("Петр", "Петров", 28));

        students.getStudentList().sort(Comparator.comparing(Student::getAge));
        System.out.println(students.toString());

        students.getStudentList().sort(Comparator.comparing(Student::getName).thenComparing(Student::getSurname));
        System.out.println(students.toString());
    }


}


