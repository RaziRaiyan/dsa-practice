package BinarySearch.Medium;

import java.util.Arrays;

/*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    You must write an algorithm that runs in O(log n) time.

    Example 1:
    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Example 2:
    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Example 3:
    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

    Constraints:
    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.
*/ 


public class MinimumInRotatedSortedArray {
    public static void main(String[] args){
        int[][] test_cases = {{3,4,5,1,2}, {4,5,6,7,0,1,2}, {11,13,15,17}};
        int[] answers = {1, 0, 11};

        for(int i = 0; i<test_cases.length; i++){
            int output = findMin(test_cases[i]);
            int expected = answers[i];
            
            System.out.println("Checking for: " + Arrays.toString(test_cases[i]) + (output == expected ? " - ✅ Passed": " - ❌ Failed") + ", Expected: "+expected + ", Output: " + output+"\n\n");
        }
    }

    public static int findMin(int[] nums) {
        // Intuition
        // We basically have to find the drop point
        // Given that array is sorted 
        // The optimal solution would be to do it in O(N), using binary search
        // When mid itself is the drop point (minimum number), it will be lesser than it's previous number
        // How do we know to which side of the search space we need to move if the above case is not applicable
        // So, if number at mid is greater than number at high point we need to perform our search space to right of mid
        // And if number at mid is lesser than number at high point we need to perform our search space to left of mid


        int low = 0, high = nums.length - 1;

        if(nums.length == 1){
            return nums[0];
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int prevNum = mid > 0 ? nums[mid-1] : nums[nums.length - 1];

            if(nums[mid] < prevNum){
                return nums[mid];
            }else if(nums[mid] > nums[high]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
