import java.util.ArrayList;
import java.util.Iterator;
public class LearnArrayList {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        // ArrayList has toString method, that's how the print statement is working
        System.out.println(list);

        // How size of ArrayList are allocated in memory
        // ArrayList are allocated in memory in a contiguous block of memory
        // The size of the ArrayList is the size of the contiguous block of memory
        // When an element is added to the ArrayList, the size of the ArrayList is increased - size = n, next size = n + n/2 +1

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            list3.add(i);
        }
        System.out.println(list3);

        list2.addAll(list3);
        System.out.println("list2 + list3 = " + list2);

        // Get the size of the ArrayList
        System.out.println("Size of list2 = " + list2.size());

        // Get the element at index 5
        System.out.println("Element at index 5 = " + list2.get(5));

        // Remove the element at index 5
        list2.remove(5);
        System.out.println("list2 after removing element at index 5 = " + list2);

        list2.remove(Integer.valueOf(10));
        System.out.println("list2 after removing element 10 = " + list2);


        for(int i = 0; i < list2.size(); i++) {
            System.out.println("Element at index " + i + " = " + list2.get(i));
        }

        for (Integer element : list2) {
            System.out.println("Element = " + element);
        }

        Iterator<Integer> it = list2.iterator();
        while(it.hasNext()) {
            System.out.println("Element = " + it.next());
        }

        // Time Complexity of ArrayList
        // add() - O(1)
        // get() - O(1)
        // remove() - O(n)
        // contains() - O(n)
        // size() - O(1)
        // add() - O(n)
        // add(index, element) - O(n)
        // addAll() - O(n)
        // set(index, element) - O(1)
        // remove() - O(n)
        // remove(index) - O(n)
        // remove(element) - O(n)
        // removeAll() - O(n)
        // clear() - O(1)
        // contains() - O(n)
        // containsAll() - O(n)
        // isEmpty() - O(1)
    }
}