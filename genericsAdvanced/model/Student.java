package genericsAdvanced.model;

import genericsAdvanced.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {

    protected static Random random = new Random();
    private static String[] firstNames = {"Seraphina", "Raphaëlle", "Allegra",
            "Roman", "Paula"};
    private static String[] courses = {"C++", "Java", "Python"};

    private String name;
    private String course;
    private int yearStarted;

    public Student() {
        int lastNameIdx = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIdx;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2019, 2023);
    }

    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
