package PracticeArrays.Easy;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,1]

// Output: 1

// Example 2:

// Input: nums = [4,1,2,1,2]

// Output: 4

// Example 3:

// Input: nums = [1]

// Output: 1

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        int singleNumber = singleNumber(arr);
        System.out.println(singleNumber);
    }

    public static int singleNumber(int[] arr) {
        int n = arr.length;
        int singleNumber = 0;
        for(int i = 0; i < n; i++){
            // XOR of a number with itself is 0
            // XOR of a number with 0 is the number itself
            // So, if we XOR all the numbers in the array, the numbers that appear twice will cancel each other out and we will be left with the number that appears only once
            singleNumber ^= arr[i];
        }
        return singleNumber;
    }
    
}
