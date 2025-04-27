import java.util.TreeMap;

public class LearnTreeMap {
    public static void main(String[] args) {    
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(5, 50);
        map.put(1, 10);
        map.put(3, 30);
        map.put(7, 70);
        map.put(6, 60);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.floorKey(2));
        System.out.println(map.ceilingKey(2));
        System.out.println(map.floorKey(5));
        System.out.println(map.ceilingKey(4));
        System.out.println(map.lastKey());

        int[] nums = {7, 4, 2, 1, 3, 9, 6};
        // Insert all numbers first
        for (int num : nums) {
            map.put(num, 1); // You can put anything as value
        }

        for(int i=0; i<nums.length; i++){
            System.out.println("Nearest smaller of "+nums[i]+" is: "+map.floorKey(nums[i]));
        }

        for(int i=0; i<nums.length; i++){
            System.out.println("Nearest larger of "+nums[i]+" is: "+map.ceilingKey(nums[i]));
        }

        // Time complexity of TreeMap is O(log n) for all operations
    }
}