import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class LearnHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(2);
        System.out.println(set);

        Scanner scanner = new Scanner(System.in);
        // Taking user input
        System.out.println("Enter the number of elements to add: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        System.out.println(set);

        // Take input from user and check if it is present in the set
        System.out.println("Enter the element to check: ");
        int x = scanner.nextInt();
        if (set.contains(x)) {
            System.out.println("Element is present");
        } else {
            System.out.println("Element is not present");
        }

        // Take string input from user and check if it is present in the set
        System.out.println("Enter the string to check: ");
        String str = scanner.next();
        if (set.contains(str)) {
            System.out.println("String is present");
        } else {
            System.out.println("String is not present");
        }

        // Remove an element from the set
        System.out.println("Enter the element to remove: ");
        int y = scanner.nextInt();
        set.remove(y);
        System.out.println(set);

        // Remove all elements from the set
        set.clear();
        System.out.println(set);
    

        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "John"));
        studentSet.add(new Student(2, "Jane"));
        studentSet.add(new Student(3, "Jim"));
        System.out.println(studentSet);

        studentSet.remove(new Student(2, "Jane"));
        System.out.println("After removing Jane: " + studentSet);

        studentSet.clear();
        System.out.println("After clearing: " + studentSet);

        List<Student> studentList = new ArrayList<>(studentSet);
        studentList.add(new Student(4, "John"));
        studentList.add(new Student(5, "Jane"));
        studentList.add(new Student(6, "Jim"));
        System.out.println("Before sorting students list: " + studentList);
        Collections.sort(studentList, (o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println("After sorting students list: " + studentList);

        // Time complexity of HashSet is O(1) for all operations
    }
}