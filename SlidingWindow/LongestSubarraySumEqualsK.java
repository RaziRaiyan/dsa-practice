package SlidingWindow;

import java.util.HashMap;

/*
    Find the length of the longest subarray whose sum is exactly equal to k.

    Example:
    nums = [3, 4, -7, 1, 3, 3, 1, -4], k = 7
    Output: 6
*/ 

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 3, 3, 1, -4};
        int k = 7;

        System.out.println(longestSubarraySumEqualsK(nums, k));
    }

    public static int longestSubarraySumEqualsK(int[] nums, int k){
        int maxLen = 0;
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i<n; i++){
            prefixSum += nums[i];

            if(map.get(prefixSum - k) != null){
                maxLen = Math.max(maxLen, i-map.get(prefixSum-k)+1);
            }

            if(map.get(prefixSum) == null){
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
