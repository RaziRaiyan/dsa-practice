package PracticeArrays.Easy;

// Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

// Examples
// Example 1:
// Input Format: N = 3, k = 5, array[] = {2,3,5}
// Result: 2
// Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

// Example 2:
// Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
// Result: 3
// Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.

public class LongestSubarrayWithKPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 9};
        int k = 10;
        int longestSubarray = longestSubarray(arr, k);
        System.out.println(longestSubarray);
    }

    public static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int curr_sum = arr[0];
        int longestSubarray = 0;
        while(right < n){
            while(left <= right && curr_sum > k){
                curr_sum -= arr[left];
                left++;
            }
            if(curr_sum == k){
                longestSubarray = Math.max(longestSubarray, right - left + 1);
            }
            curr_sum += arr[right];
            right++;
        }
        return longestSubarray;
    }
}
