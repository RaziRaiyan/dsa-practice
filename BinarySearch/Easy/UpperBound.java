package BinarySearch.Easy;

/*
    Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

    Example 1:
    Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
    Result: 3
    Explanation: Index 3 is the smallest index such that arr[3] > x.

    Example 2:
    Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
    Result: 4
    Explanation: Index 4 is the smallest index such that arr[4] > x.
*/ 

public class UpperBound {

    public static void main(String[] args){
        int[] nums = {1,2,2,3};
        int x = 2;

        System.out.println(findUpperBound(nums, x));
    }

    public static int findUpperBound(int[] nums, int x){
        int low = 0, high = nums.length-1;

        while(low < high) {
            int mid = low + (high - low)/2;

            if(nums[mid] <= x) low = mid + 1;
            else high = mid;
        }

        return low;
    }
    
}
