package collections;

import java.util.HashSet;

public class UniqueStudents {

    HashSet<String> students = new HashSet<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void findStudent(String name) {

        if (students.contains(name)) {
            System.out.println("Найден: " + name);
        }
    }

    public void printStudents() {

        for (String student : students) {
            System.out.println(student);
        }
    }
}