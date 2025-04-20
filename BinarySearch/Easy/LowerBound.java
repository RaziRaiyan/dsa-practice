package BinarySearch.Easy;

/*
    Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

    Example 1:
    Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
    Result: 1
    Explanation: Index 1 is the smallest index such that arr[1] >= x.

    Example 2:
    Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
    Result: 3
    Explanation: Index 3 is the smallest index such that arr[3] >= x.
*/ 

public class LowerBound {
    public static void main(String[] args){
        int[] nums = {1,2,2,3};
        int x = 2;

        System.out.println(findLowerBound(nums, x));
    }

    public static int findLowerBound(int[] nums, int x){
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] == x) return mid;
            if(nums[mid] <  x) low = mid + 1;
            else high = mid;
        }

        return high;
    }
}
