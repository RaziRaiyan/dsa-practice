package BinarySearch.Medium;

/*
    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
    Return the single element that appears only once.

    Your solution must run in O(log n) time and O(1) space.

    Example 1:
    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2

    Example 2:
    Input: nums = [3,3,7,7,10,11,11]
    Output: 10

    Constraints:
    1 <= nums.length <= 105
    0 <= nums[i] <= 105
*/ 

public class SingleElement {
    public static void main(String[] args){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        // Intuition
        // Given that array is sorted, we can surely do much better than O(n) solution, better than O(N) is O(logN) and since the array is sorted we can apply binary search technique here.
        // Now, how do we identify if the mid element is the single element? - just simply check the neighbouring elements
        // Also, how do we decide if we need to check to left of the search space or to the right of search space? - 
        // the idea here is the start of doubly duplicate number to the right of single element will start at even indices
        // and the start of doubly duplicate number to the left of single element will start at odd indices
        int low = 0, high = nums.length-1;

        if(nums.length == 1){
            return nums[0];
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            int prevNum = mid > 0 ? nums[mid-1] : Integer.MIN_VALUE;
            int nextNum = mid < nums.length-1 ? nums[mid+1] : Integer.MAX_VALUE;
            
            if((prevNum < nums[mid] && nums[mid] < nextNum) || (prevNum > nums[mid] && nums[mid] > nextNum)){
                return nums[mid];
            }else {
                int startOfRepeatedNum = nums[mid] == nums[mid-1] ? mid - 1 : mid;
                if(startOfRepeatedNum%2 == 0){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
