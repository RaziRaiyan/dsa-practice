package SlidingWindow;

/*
    Problem Statement: Find the length of the longest subarray with a sum less than or equal to K.

    Example: 
    nums = [2, 1, 3, 2, 4, 3]
    K = 7
    Output: 3
    Constraint: All the numbers in the array are positives
*/ 

/*
    Next Challenge: What if the numbers in the array are positive, negative and zeros?
*/ 

public class LongestSubarraySumLessThanEqualsToK {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2, 4, 3};
        int k = 7;
        System.out.println(longestSubarraySumLessThanEqualsToK(nums, k));

    }

    public static int longestSubarraySumLessThanEqualsToK(int[] nums, int k){
        int maxLen = 0;
        int left = 0;
        int sum = 0;

        for(int right=0; right<nums.length; right++){
            sum += nums[right];

            while(sum > k){
                sum -= nums[left];
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
