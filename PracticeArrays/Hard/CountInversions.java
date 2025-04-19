package PracticeArrays.Hard;

// Given an array of N integers, count the inversion of the array

// Example 1:
// Input Format: N = 5, array[] = {1,2,3,4,5}
// Result: 0
// Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

// Example 2:
// Input Format: N = 5, array[] = {5,4,3,2,1}
// Result: 10
// Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

// Example 3:
// Input Format: N = 5, array[] = {5,3,2,1,4}
// Result: 7
// Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition. 

public class CountInversions {
    public static void main(String[] args){
        int[] nums = {5,3,2,1,4};
        System.out.println(countInversions(nums, 0, nums.length-1));
    }

    public static int countInversions(int[] nums, int start, int end){
        System.out.println("Inside countInversions");
        int inversions = 0;
        if(start < end){
            int mid = start + (end - start)/2 ;
            inversions += countInversions(nums, start, mid);
            inversions += countInversions(nums, mid+1, end);
            inversions += getInversions(nums, start, mid, end);
            merge(nums, start, mid, end);
        }

        return inversions;
    }
    
    public static int getInversions(int[] nums, int low, int mid, int high){
        System.out.println("Inside getInversions");

        int inversions = 0;

        int i = low;
        int j = mid+1;

        while(i <= mid && j <= high){
            if(nums[i] > nums[j]){
                inversions += (mid - i + 1);
                j++;
            }else{
                i++;
            }
        }

        return inversions;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        System.out.println("Inside merge");
        int temp[] = new int[high - low + 1];
        int curr = 0;

        int i = low, j = mid+1;
        while(i <= mid && j <= high){
            if(nums[i] < nums[j]){
                temp[curr++] = nums[i++];
            }else{
                temp[curr++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[curr++] = nums[i++];
        }

        while(j <= high){
            temp[curr++] = nums[j++];
        }

        curr = 0;
        for(int k=low; k<= high; k++){
            nums[k] = temp[curr++];
        }
    }
    
}
