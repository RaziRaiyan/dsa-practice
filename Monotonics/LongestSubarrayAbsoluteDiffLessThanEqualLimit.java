package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 
 * Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * 
 * Given an array of integers nums and an integer limit, 
 * return the size of the longest non-empty subarray such that 
 * the absolute difference between any two elements of
 * this subarray is less than or equal to limit.
 
    Example 1:
    Input: nums = [8,2,4,7], limit = 4
    Output: 2 
    Explanation: All subarrays are: 
    [8] with maximum absolute diff |8-8| = 0 <= 4.
    [8,2] with maximum absolute diff |8-2| = 6 > 4. 
    [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
    [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
    [2] with maximum absolute diff |2-2| = 0 <= 4.
    [2,4] with maximum absolute diff |2-4| = 2 <= 4.
    [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
    [4] with maximum absolute diff |4-4| = 0 <= 4.
    [4,7] with maximum absolute diff |4-7| = 3 <= 4.
    [7] with maximum absolute diff |7-7| = 0 <= 4. 
    Therefore, the size of the longest subarray is 2.
*/

public class LongestSubarrayAbsoluteDiffLessThanEqualLimit {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;

        System.out.println(longestSubarrayAbsoluteDiffLessThanEqualLimit(nums, limit));
    }

    public static int longestSubarrayAbsoluteDiffLessThanEqualLimit(int[] nums, int limit){
        int n = nums.length;
        int maxLen = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;

        for(int right=0; right<n; right++){
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if(maxDeque.peekFirst() == nums[left]){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst() == nums[left]){
                    minDeque.pollFirst();
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }


        return maxLen;
    }
}
