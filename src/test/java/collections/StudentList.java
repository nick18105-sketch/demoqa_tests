package collections;

import java.util.ArrayList;

public class StudentList {

    ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void findStudent(String name) {

        for (String student : students) {

            if (student.equals(name)) {
                System.out.println("Студент найден: " + student);
            }
        }
    }

    public void printStudents() {

        for (String student : students) {
            System.out.println(student);
        }
    }
}