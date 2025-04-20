package BinarySearch.Easy;

import java.util.Arrays;

/*
    You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
    The floor of x is the largest element in the array which is smaller than or equal to x.
    The ceiling of x is the smallest element in the array greater than or equal to x.

    Pre-requisite: Lower Bound & Binary Search

    Example 1:
    Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
    Result: 4 7
    Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

    Example 2:
    Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
    Result: 8 8
    Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

*/ 

public class FloorAndCeil {
    public static void main(String[] args){
        int[] nums = {3, 4, 4, 7, 8, 10};
        int x = 5;

        System.out.println(Arrays.toString(floorAndCeil(nums, x)));
    }

    public static int[] floorAndCeil(int[] nums, int x){
        int floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] == x){
                if(mid > 0){
                    floor = nums[mid-1];
                }
                if(mid < nums.length-1){
                    ceil = nums[mid+1];
                }

                return new int[]{floor, ceil};
            }else if(nums[mid] > x){
                high = mid - 1; 
            }else{
                low = mid + 1;
            }
        }

        if(nums[low] > x){
            return new int[]{nums[low-1], nums[low]};
        }else{
            return new int[]{nums[low], nums[low+1]};
        }
    }
}
