package comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: .compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        System.out.println("=".repeat(30));

        // For strings, we get the difference in unicode...

        String banana = "banana";
        String[] fruits = {"apple", "banana", "pear", "BANANA"};

        for (String fruit : fruits) {
            int val = banana.compareTo(fruit);
            System.out.printf("%s %s %s: .compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), fruit, val);
        }

        System.out.println("=".repeat(30));

        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        // To see unicode value:
        System.out.println("A:" + (int)'A' + " " + "a:" + (int)'a');
        System.out.println("B:" + (int)'B' + " " + "b:" + (int)'b');
        System.out.println("P:" + (int)'P' + " " + "p:" + (int)'p');

        System.out.println("=".repeat(30));

        Student paula = new Student("Paula");
        Student[] students = {new Student("Seraphina"), new Student("Raphaëlle"),
                new Student("Allegra"), new Student("Roman")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + paula.compareTo(new Student("PAULA")));

        System.out.println("=".repeat(30));

        // How to use the overloaded Arrays.sort() method...
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));
        // E.g., --> [1004 - Roman (1.58), 1002 - Raphaëlle (3.55), 1003 - Allegra (3.69), 1001 - Seraphina (3.70)]
        // To get the reversed order I could change the .compare() method, however it is clearer
        // to use the reverse default method on the Comparator interface...
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
        // E.g., --> [1001 - Seraphina (3.70), 1003 - Allegra (3.69), 1002 - Raphaëlle (3.55), 1004 - Roman (1.58)]

    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    // No access modifier means package private. Could also be protected for this
    // purpose.
    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
//        return Integer.compare(id, o.id);
//        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
        return Integer.valueOf(id).compareTo(o.id);
    }

    //    @Override
//    public int compareTo(Object o) {
//        Student otherStudent = (Student) o;
//        return name.compareTo(otherStudent.name);
//    }
}
