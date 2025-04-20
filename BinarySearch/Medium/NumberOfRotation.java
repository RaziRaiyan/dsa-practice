package BinarySearch.Medium;

/*
    Given an integer array arr of size N, sorted in ascending order (with distinct values).
     Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated. 

     Example 1:
    Input Format: arr = [4,5,6,7,0,1,2,3]
    Result: 4
    Explanation: The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

    Example 2:
    Input Format: arr = [3,4,5,1,2]
    Result: 3
    Explanation: The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.
*/ 

public class NumberOfRotation {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2,3};
        System.out.println(numberOfRotation(nums));
    }

    public static int numberOfRotation(int[] nums){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int prevNum = mid > 0 ? nums[mid-1] : Integer.MIN_VALUE;

            System.out.println("mid: "+ mid + ", nums[mid]: "+ nums[mid] + ", nums[low]: " + nums[low] + ", nums[high]: "+ nums[high]);

            if(nums[mid] < prevNum){
                return mid;
            }else if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
