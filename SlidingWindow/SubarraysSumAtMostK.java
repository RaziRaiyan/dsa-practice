package SlidingWindow;
/*
    You are given an array nums consisting of positive integers, and an integer k.
    Return the total number of contiguous subarrays such that the sum of elements in the subarray is less than or equal to k.
*/ 

public class SubarraysSumAtMostK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 5, 4, 2, 5, 1, 1, 1, 4, 5, 6, 4};
        int target = 10;

        // int[] nums = new int[]{1, 1, 1};
        // int target = 2; // [1], [1, 1], [1], [1, 1], [1]
        System.out.println(subarraysSumAtMostK(nums, target));
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
