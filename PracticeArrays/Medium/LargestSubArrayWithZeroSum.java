package PracticeArrays.Medium;

import java.util.HashMap;

/*
    Given an array containing both positive and negative integers,
    we have to find the length of the longest subarray with the sum of all elements equal to zero.

    Example 1:
    Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
    Result: 5
    Explanation: The following subarrays sum to zero:
    {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
    Since we require the length of the longest subarray, our answer is 5!

    Example 2:
    Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
    Result: 8
    Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
    Length of longest subarray = 8

    Example 3:
    Input Format: N = 3, array[] = {1, 0, -5}
    Result: 1
    Subarray : {0}
    Length of longest subarray = 1

    Example 4:
    Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
    Result: 0
    Subarray: There is no subarray that sums to zero
*/ 

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args){
        int[] nums = {6, -2, 2, -8, 1, 7, 4, -10};
        System.out.println(largestSubArrayWithZeroSum(nums));
    }

    public static int largestSubArrayWithZeroSum(int[] nums){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int max = 0;
        int sum = 0;
        sumMap.put(0, -1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sumMap.get(sum) != null){
                max = Math.max(max, i - sumMap.get(sum));
            }else{
                sumMap.put(sum, i);
            }
        }
        
        return max;
    }
}