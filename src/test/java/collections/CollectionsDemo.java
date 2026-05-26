package collections;

public class CollectionsDemo {

    public static void main(String[] args) {

        System.out.println("=== ArrayList ===");

        StudentList students = new StudentList();

        students.addStudent("Коля");
        students.addStudent("Иван");
        students.addStudent("Петя");

        students.printStudents();

        students.findStudent("Иван");

        students.removeStudent("Петя");

        System.out.println();


        System.out.println("=== HashMap ===");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Коля", "899999999");
        phoneBook.addContact("Иван", "888888888");

        phoneBook.printContacts();

        phoneBook.findContact("Коля");

        System.out.println();


        System.out.println("=== HashSet ===");

        UniqueStudents unique = new UniqueStudents();

        unique.addStudent("Коля");
        unique.addStudent("Коля");
        unique.addStudent("Иван");

        unique.printStudents();

        System.out.println();


        System.out.println("=== LinkedList ===");

        TaskQueue queue = new TaskQueue();

        queue.addTask("Тест №1");
        queue.addTask("Тест №2");
        queue.addTask("Тест №3");

        queue.printTasks();

        queue.removeTask();

        System.out.println("После удаления:");

        queue.printTasks();
    }
}