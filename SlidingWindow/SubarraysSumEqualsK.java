package SlidingWindow;

public class SubarraysSumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 5, 4, 2, 5, 1, 1, 1, 4, 5, 6, 4};
        int target = 10;

        // int[] nums = new int[]{1, 1, 1};
        // int target = 2; // [1], [1, 1], [1], [1, 1], [1]
        System.out.println(subarraysSumAtMostK(nums, target) - subarraysSumAtMostK(nums, target-1));

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        String s = "apple";
        
    }


    public static int subarraysSumAtMostK (int[] nums, int target){
        int left = 0, sum = 0, count = 0;
        

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left++];
            }
            
            count += (right - left + 1);
        }

        return count;
    }
}
