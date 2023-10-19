package comparing;

import java.util.Arrays;

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
    }
}

class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
