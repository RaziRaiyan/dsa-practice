package BinarySearch.Medium;

/*
    A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

    You must write an algorithm that runs in O(log n) time.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.

    Example 2:
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
    

    Constraints:
    1 <= nums.length <= 1000
    -231 <= nums[i] <= 231 - 1
    nums[i] != nums[i + 1] for all valid i.
*/ 

public class FindPeakElement {
    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    // Intuition
    // Since it is given that we have to find the peak element in O(log(n)) time, it clicked that it has to do something with binary search
    // Let's say if our array have only one peak, then peak could be the mid number or mid number could be to right of peak or could be to left of peak
    // If the mid number is peak itself then we return the mid value, since the question says that we can return any of the peak
    // If the mid number is to right of the peak, then at the point of mid - it will be an ascending slope - i.e nums[mid-1] <= nums[mid] < nums[mid+1], hence we can move our search space to the left of mid
    // If the mid number is to left of the peak, then at the point of mid - it will be a descending slope - i.e nums[mid-1] >= nums[mid] > nums[mid+1], hendce we can move our search space to the right of mid

    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        if(nums.length == 1)
            return 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            int prevNum = mid > 0 ? nums[mid-1] : Integer.MIN_VALUE;
            int nextNum = mid < nums.length-1 ? nums[mid+1]: Integer.MIN_VALUE;

            if(prevNum < nums[mid] && nums[mid] > nextNum){
                return mid;
            }else if(prevNum <= nums[mid] && nums[mid] <= nextNum){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
