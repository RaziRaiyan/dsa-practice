package BinarySearch.Medium;

import java.util.Arrays;

/*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]
    

    Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
*/ 

public class FirstAndLastOccurence {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

        System.out.println(canFinish(nums, 3, 4));
    }

    public static boolean canFinish(int[] nums, int k, int h){
        int totalHours = 0;
        for(int i=0; i<nums.length; i++){
            int currTime = (int)Math.ceil(((double)nums[i])/k);
            System.out.println("currTime: "+ totalHours+" "+(nums[i]/k)+" "+((double)nums[i])/k);
            totalHours += currTime;
        }

        System.out.println("totalHours: "+ totalHours);

        return totalHours <= h;
    }

    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1, last = -1;

        // first occurence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                high = mid-1;
                first = mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        low = 0;
        high = nums.length-1;

        // last occurence
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                low = mid+1;
                last = mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return new int[]{first, last};
    }
}
