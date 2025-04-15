import java.util.HashMap;
import java.util.Map;

public class LearnHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);

        map.put("Four", 4);
        System.out.println(map);

        System.out.println("Contains key One: " + map.containsKey("One"));
        System.out.println("Contains value 1: " + map.containsValue(1));

        map.remove("One");
        System.out.println(map);

        map.remove("Two", 2);
        System.out.println(map);

        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        map.clear();
        System.out.println(map);

        // Time complexity of HashMap is O(1) for all operations
    }
}