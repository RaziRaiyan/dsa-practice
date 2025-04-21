package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array print all the sum of the subset generated from it, in the increasing order.

    Examples:

    Example 1:
    Input: N = 3, arr[] = {5,2,1}
    Output: 0,1,2,3,5,6,7,8
    Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are 
    [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8

    Example 2:
    Input: N=3,arr[]= {3,1,2}
    Output: 0,1,2,3,3,4,5,6
    Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are 
    [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6

*/ 

public class SubsetSum1 {
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {3,1,2};

        subsetSum(nums, 0, 0);
        System.out.println(ans);

    }

    public static void subsetSum(int[] nums, int start, int sum){
        if(start >= nums.length){
            ans.add(sum);
            return;
        }

        ans.add(sum);

        for(int i=start; i<nums.length; i++){
            subsetSum(nums, i+1, sum+nums[i]);
        }

        String s = "apple";
        s.substring(0, 10);
    }


}
