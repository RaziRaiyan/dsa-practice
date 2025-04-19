package PracticeArrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

public class SubArraySumEqualsK {
    public static void main(String[] args){
        int[] nums = {1, 4, 1, 1, 2, 3, 1, 1};
        int k = 5;
        System.out.println(subArraySum(nums, k));

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));

        System.out.println(list.get(0));
    }

    public static int subArraySum(int[] nums, int k){
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumsFrequency = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sumsFrequency.get(sum - k) != null){
                res += sumsFrequency.get(sum - k);
            }

            sumsFrequency.put(sum, sumsFrequency.getOrDefault(sum, 0)+1);
        }

        return res;
    }
    
    
}
