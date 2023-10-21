package genericsAdvanced;

import genericsAdvanced.model.BirkbeckStudent;
import genericsAdvanced.model.Student;
import genericsAdvanced.util.QueryItem;
import genericsAdvanced.util.QueryList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }

        printMoreList(students);

        System.out.println("=".repeat(60));

        List<BirkbeckStudent> bbkStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            bbkStudents.add(new BirkbeckStudent());
        }

        printMoreList(bbkStudents);

        System.out.println("=".repeat(60));

        testList(new ArrayList<String>(List.of("Seraphina", "Raphaëlle", "Allegra",
                "Roman", "Paula")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3, 4, 5)));

        System.out.println("=".repeat(60));

        var queryList = new QueryList<>(bbkStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreList(matches);

        System.out.println("=".repeat(60));

        var students2021 = QueryList.getMatches(students,"yearStarted", "2021");
        printMoreList(students2021);

        System.out.println("=".repeat(60));

//        QueryList<Employee> employeeList = new QueryList<>();

    }

    // To code it that it works...
    public static void testList(List<?> list) {

        for (var el : list) {
            if (el instanceof String str) {
                System.out.println("String: " + str.toUpperCase());
            }else if (el instanceof Integer integer) {
                System.out.println("Integer: " + integer.floatValue());
            }
        }
        System.out.println();
    }

//    public static void testList(List<String> list) {
//
//        for (var el : list) {
//            System.out.println("String: " + el.toUpperCase());
//        }
//    }
//
//    // Because of erasure does not work here... they have the same type erasure.
//    // Because there is no upper bound, it always resolves to java.lan.Object in byte code.
//    public static void testList(List<Integer> list) {
//
//        for (var el : list) {
//            System.out.println("Integer: " + el.floatValue());
//        }
//    }

    // Non-generic method with wildcard argument type
    public static void printMoreList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

// For all the reasons, let's make this a generic method...
//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }

//    public static void printList(List students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }
}

record Employee(String name) implements QueryItem {


    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
