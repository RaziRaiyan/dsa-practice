package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving 
 * from the very left of the array to the very right. You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * 
    Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation: 
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7      3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7

    Intuition:
    1. For each window of size K, we want to know the maximum element
    2. Okay, we can keep track of max element
    3. But, what will happen if our max element leaves the window as we slide our window
    4. We would want to store the next max element - This can be done by either Priority Queue (Size k) or Monotonic Deque (Decreasing order)
    4.1. Priority Queue operations will take O(logk) time
    4.2. Monotonic Deque operations will take O(1) time (Almost)
    5. We will use Monotonic Deque
    5.1 On each iteration we will try to store the element on the right end of window in Monotonic Deque
    5.2 But how will we make sure that our max element has not left window? - Should we store the index along as well? - 
        It would be better to store the indices instead of actual element
    5.3 Now since we are storing the indices we can check if the element has left the window - If so, we will remove that element from Deque
 */

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(slidingWindowMaximum(nums, k)));
    }

    public static int[] slidingWindowMaximum(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> deque = new LinkedList<>();
        int end = 0;
        for(; end<k; end++){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[end]) {
                deque.pollLast();
            }
            deque.offerLast(end); // storing indices
        }
        ans[0] = deque.peek();

        int start = 0;
        for(; end<n; end++){
            start++;
            while(!deque.isEmpty() && deque.peekFirst() < start) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[end]) {
                deque.pollLast();
            }
            deque.offerLast(end); // storing indices

            ans[end-k+1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}
