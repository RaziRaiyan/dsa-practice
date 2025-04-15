import java.util.Arrays;

public class LearnArraysClass {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 2, 3, 4};
        System.out.println("Before sorting: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 5);
        System.out.println("Binary search for 5: " + index);

        Arrays.sort(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));

        Arrays.copyOf(numbers, 3);
        System.out.println("After copying: " + Arrays.toString(numbers));

        int[] numbersCopy = numbers.clone();
        System.out.println("After cloning: " + Arrays.toString(numbersCopy));

        int[] numbersCopyOf = Arrays.copyOf(numbers, 3);
        System.out.println("After copying of: " + Arrays.toString(numbersCopyOf));
    }
}
