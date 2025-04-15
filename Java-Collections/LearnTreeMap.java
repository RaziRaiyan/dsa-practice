import java.util.TreeMap;

public class LearnTreeMap {
    public static void main(String[] args) {    
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(9, "Nine");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(2, "Two");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(3, "Three");
        map.put(8, "Eight");
        map.put(10, "Ten");


        System.out.println(map);

        map.put(4, "Four");
        System.out.println("After adding 4: " + map);

        map.remove(2);
        System.out.println("After removing 2: " + map);

        map.clear();
        System.out.println("After clearing: " + map);


        // Time complexity of TreeMap is O(log n) for all operations
    }
}