package PracticeArrays.Hard;

import java.util.Arrays;

/*
    Find the repeating and missing numbers

    Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. 
    Each integer appears exactly once except A which appears twice and B which is missing. 
    The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

    Example 1:
    Input Format:  array[] = {3,1,2,5,3}
    Result: {3,4)
    Explanation: A = 3 , B = 4 
    Since 3 is appearing twice and 4 is missing

    Example 2:
    Input Format: array[] = {3,1,2,5,4,6,7,5}
    Result: {5,8)
    Explanation: A = 5 , B = 8 
    Since 5 is appearing twice and 8 is missing
*/ 

public class FindRepeatingAndMissingNumbers {
    public static void main(String[] args){
        int[] nums = {3,1,2,5,3};
        System.out.println(Arrays.toString(findRepeatingAndMissingNumbers(nums)));
    }

    public static int[] findRepeatingAndMissingNumbers(int[] nums){
        int n = nums.length;
        int sum = n*(n+1)/2;
        int sum_of_squares = n*(n+1)*(2*n+1)/6;

        int nums_sum = 0, nums_square_sum = 0;
        for(int i=0; i<n; i++){
            nums_sum += nums[i];
            nums_square_sum += nums[i]*nums[i];
        }

        // int x = -1, y = -1;
        // x - y = nums_sum - sum
        // x2 - y2 = nums_square_sum - sum_of_squares -> (x - y)(x + y) -> w*v
        // w -> x - y -> nums_sum - sum
        // v -> x + y -> (nums_square_sum - sum_of_squares) / w
        // (w + v)/2 -> x
        // y -> v - x

        int w = (nums_sum - sum);
        int v = (nums_square_sum - sum_of_squares) / w;
        int x = (w + v) / 2;
        int y = v - x;

        return new int[]{x, y};
    }
        
}
