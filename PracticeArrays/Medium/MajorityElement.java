package PracticeArrays.Medium;

// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 10^4
// -10^9 <= nums[i] <= 10^9

public class MajorityElement {
    // Moore's Voting Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                candidate = nums[i+1];
            }
        }

        return candidate;
    }
}
