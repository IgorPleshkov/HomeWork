package Home_work.Lambda;

import com.itmo.jjd.Lesson15.Collection.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class StudentList {
        private List<Student> studentList = new ArrayList<>();

        public List<Student> getStudentList() {
            return studentList;
        }

        public void addStudent(Student student) {
            studentList.add(Objects.requireNonNull(student));
            }

    @Override
    public String toString() {
            StringBuffer sb = new StringBuffer();
            for (Student st : studentList){
               sb.append(st.toString()+"\n");
            }
        return sb.toString();
    }
}
